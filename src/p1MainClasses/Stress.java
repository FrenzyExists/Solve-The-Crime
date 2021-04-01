package p1MainClasses;

import dataGenerator.DataGenerator;
import indexlist.LinkedIndexList;
import insersections.AlfaBeta;
import insersections.Delta;
import insersections.Yakama;
import strategies.StrategyCollection;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.AbstractMap;


/**
 * Stress test all 4 methods. This is part of the optional part of the project
 *
 * Here, we represent an object data type that could carry the stress
 * test to estimate execution times of a particular "Strategy" (Method)
 * to solve each set intersection.
 *
 * f(x) <= cg(x), for all c <= k
 *
 *
 * Example of basic output without any plotting
 *
 * Size  |  P1         |   P2        |      P3      P4
 * ------------------------------------------------------------------
 * 1000  |  115692.42  |  110655.45  |     190051.38       148219.77
 * 1100  |  79439.08   |  66471.37   |     97530.26        76653.66
 * 1200  |  61045.586  |  40878.035  |     86872.15        64969.496
 * 1300  |  60649.805  |  41483.46   |     74643.94        74065.69
 * 1400  |  61781.88   |  44946.67   |     72130.63        39031.44
 */
public class Stress {

    private int initialSize;
    private int finalSize;
    private int incrementalSizeStep;
    private int repetitionsPerSize;

    /**
     * The i-th position will contain a particular strategy being tested.
     * At the end, the i-th position will also contain a list of pairs
     * (n, t), where t is the estimated time for size n for the strategy
     * at that position.
     */
    private LinkedIndexList<StrategyCollection<Integer>> resultsPerStrategy;

    private static int[] params = new int[7]; // Params n stuff

    /**
     * @param args: n  m  isize  fsize  istep  rep  graph  save  path-to-save
     *
     * n - the number of companies
     * m - the number of crime events
     * isize - the initial size for experimentation
     * fsize - final size for experimentation
     * istep - increment of sizes
     * rep - number of repetitions for a each size
     * graph - boolean val: true -> plot with gnuplot | false -> output table of values only
     */
    public static void main(String[] args) {

        // Kill the process, the wrapper is the one managing the verbose
        if (args.length < 1)
            return;

        for (int i=0 ; i < 4 ; i++) {
            params[i] = Integer.parseInt(args[i]);
        }

        //
        Stress tester = new Stress(params[0], params[1], params[2], params[3]);

        /**/
        tester.addStrategy(new StrategyCollection<>(new AlfaBeta<>("P1")));
        tester.addStrategy(new StrategyCollection<>(new AlfaBeta<>("P2")));
        tester.addStrategy(new StrategyCollection<>(new Delta<>()));
        tester.addStrategy(new StrategyCollection<>(new Yakama<>()));
        /**/

        tester.run();    // run the experiments on all the strategies added to the controller object (ec)

        // save the results for each strategy....
//        try {
//            tester.saveResults();
//        } catch (FileNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

    }

    /**
     * The i-th position will contain a particular strategy being tested. At the end, the
     * i-th position will also contain a list of pairs (n, t), where t is the estimated
     * time for size n for the strategy at that position.
     *
     * @param is
     * @param fs
     * @param iss
     * @param rep
     */
    public Stress(int is, int fs, int iss, int rep) {
        initialSize = is;
        repetitionsPerSize = rep;
        incrementalSizeStep = iss;
        finalSize = fs;
        resultsPerStrategy = new LinkedIndexList<>();
    }

    /**
     *
     * @param strategy
     */
    public void addStrategy(StrategyCollection<Integer> strategy) {
        resultsPerStrategy.add(strategy);
    }

    /**
     *
     * @param n
     * @param m
     * @param size
     * @return
     */
    private Object[][][] generateData(int n, int m, int size) {
        DataGenerator dg = new DataGenerator(n, m, size);
        Object[][][] data = dg.generateData();

        return data;
    }

    public void saveResults() throws FileNotFoundException {

        PrintStream out = new PrintStream(new File("experimentalResults", "allResults.txt"));
        out.print("Size");

        for (LinkedIndexList<StrategyCollection<Integer>> it = resultsPerStrategy; it.hasNext(); ) {
            StrategyCollection<Integer> strats = it.next();
            out.println("\t" + strats.getStrategyName());
        }

        out.println();

        int numberOfExperiments = resultsPerStrategy.get(0).size();
        for (int i=0; i<numberOfExperiments; i++) {
            out.print(resultsPerStrategy.get(0).get(i).getKey());
            for (LinkedIndexList<StrategyCollection<Integer>> it = resultsPerStrategy; it.hasNext(); ) {
                StrategyCollection<Integer> trc = it.next();
                out.print("\t" + trc.get(i).getValue());
            }
            out.println();
        }

        out.close();
    }


    /**
     *
     */
    public void run() {
        if (resultsPerStrategy.isEmpty())
            throw new IllegalStateException("No strategy has been added.");
        for (int size=initialSize; size<=finalSize; size+=incrementalSizeStep) {
            // For each strategy, reset the corresponding variable that will be used
            // to store the sum of times that the particular strategy exhibits for
            // the current size size
            for (LinkedIndexList<StrategyCollection<Integer>> it = resultsPerStrategy; it.hasNext(); ) {
                StrategyCollection<Integer> strategy = it.next();
                strategy.resetSum();
            }

            // Run all trials for the current size.
            for (int r = 0; r<repetitionsPerSize; r++) {
                // The following will be the common dataset to be used in the current
                // trial by all the strategies being tested.
                Object[][][] data = generateData(size, 1000, 50);

                // Apply each one of the strategies being tested using the previous
                // dataset (of size size) as input; and, for each, estimate the time
                // that the execution takes.
                for (LinkedIndexList<StrategyCollection<Integer>> it = resultsPerStrategy; it.hasNext(); ) {
                    StrategyCollection<Integer> strategy = it.next();
                    // no need to clone the data set to be used by each strategy since
                    // no modification of it is done in the process...
                    long startTime = System.nanoTime(); // System.currentTimeMillis();   // time before

//                    strategy.runTrial(data.clone());   // run the particular strategy...

                    long endTime = System.nanoTime(); // System.currentTimeMillis();    // time after

                    // accumulate the estimated time (add it) to sum of times that
                    // the current strategy has exhibited on trials for datasets
                    // of the current size.
                    strategy.incSum((int) (endTime-startTime));

                }
            }

            for (LinkedIndexList<StrategyCollection<Integer>> it = resultsPerStrategy; it.hasNext(); ) {
                StrategyCollection<Integer> strategy = it.next();
//                strategy.add(new AbstractMap.SimpleEntry<Integer, Float>
//                        (size, (strategy.getSum()/((float) repetitionsPerSize))));
            }

            System.out.println(size);

        }

    }

    /**
     *
     */
    public void prettyPrint() {
        if (resultsPerStrategy.isEmpty()) {
            throw new IllegalStateException("No strategy has been added");
        }
    }
}
