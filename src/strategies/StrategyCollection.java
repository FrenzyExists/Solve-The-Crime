package strategies;

import dataGenerator.DataGenerator;
import indexlist.LinkedIndexList;
import insersections.AlfaBeta;
import interfases.FSet;
import interfases.IndexList;
import interfases.IntersectionFinder;
import setImplementations.Set1;

import java.util.AbstractMap;
import java.util.Map;


/**
 * @param <T>
 *
 * An object of this type will contain the results of random experiments
 * to estimate the average execution time per size of a particular strategy.
 * It also stores the partial sum of the times that the particular strategy
 * has taken during the experimental trials.
 *
 * An object of this type will embed a particular strategy. When that particular
 * strategy is executed from an ExperimentController object, this object will
 * contain the computed average execution times for each input size that it
 * has experimented with.
 *
 * Notice that this is implemented as a subclass of
 * IndexList<Map.Entry<Integer, Float>>
 *
 */
public class StrategyCollection<T> extends  LinkedIndexList<Map.Entry<Integer, Float>> {
    private float sum;
    private IntersectionFinder<T> strategy;

    public StrategyCollection(IntersectionFinder<T> strategy) {
        this.strategy = strategy;
    }

    /**
     *
     * @param data
     */
    public void runTrial(FSet<T>[] data) throws CloneNotSupportedException {
        strategy.intersectSets(data);
    }

    /**
     *
     */
    public void resetSum() {
        sum = 0.0f;
    }

    /**
     *
     * @param estimatedTime
     */
    public void incSum(float estimatedTime) {
        sum += estimatedTime;
    }

    /**
     *
     * @param mappy
     * @param <E>
     */
    public <E> void add(AbstractMap.SimpleEntry<T, E> mappy) {

    }

    /**
     *
     * @return
     */
    public float getSum() {
        return sum;
    }

    /**
     *
     * @return
     */
    public String getStrategyName() {
        return strategy.getName();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        int[] parms = {50, 1000, 50, 200};

        IndexList<StrategyCollection<Integer>> resultsPerStrategy = new LinkedIndexList<>();
        resultsPerStrategy.add(new StrategyCollection<>(new AlfaBeta<>("P1")));

        for (int size=parms[0]; size<=parms[1]; size+=parms[2]) {
//            System.out.println(size + " step");
            Object[][][] data = generateData(10, 50, size);


            while (resultsPerStrategy.hasNext()) {
                StrategyCollection<Integer> strategy = resultsPerStrategy.next();

                long startTime = System.nanoTime();
                strategy.runTrial(Set1.union(data));
                long endTime = System.nanoTime();
                System.out.println(endTime);

                strategy.incSum(endTime-startTime);
                System.out.println(strategy.sum);

            }
        }

    }

    private static Object[][][] generateData(int n, int m, int size) {
        DataGenerator dg = new DataGenerator(n, m, size);
        Object[][][] data = dg.generateData();

        return data;
    }
}
