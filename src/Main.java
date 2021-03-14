import dataGenerator.DataReader;
import insersections.*;
import interfases.FSet;
import setImplementations.Set1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {

    // This is where things start... This initializes everything
    public static void main(String[] args) throws FileNotFoundException, CloneNotSupportedException {

        String daPath;
        IntersectionFinder<Integer>[] daSetArray = new IntersectionFinder[4];

        // Kill the process, the wrapper is encharged of the verbose
        if (args.length < 1)
            return;

        if ("default".equals(args[1])) {
            daPath = "";
        } else {
            daPath = args[1];
        }

        switch (args[0]) {
            case "p1" -> daSetArray[0] = new Alfa<Integer>();
            case "p2" -> daSetArray[1] = new Beta<Integer>();
            case "p3" -> daSetArray[2] = new Delta<Integer>();
            case "p4" -> daSetArray[3] = new Yakama<Integer>();
            case "all" -> {
                daSetArray[0] = new Alfa<Integer>();
                daSetArray[1] = new Beta<Integer>();
                daSetArray[2] = new Delta<Integer>();
                daSetArray[3] = new Yakama<Integer>();
            }
        }

        DataReader test;
        if (daPath.equals("")) {
            GenerateMain.main(new String[]{"10", "10", "10"});
            test = new DataReader();
        }
        else {
            test = new DataReader(daPath);
        }


        Object[][][] files = test.readDataFiles();

        FSet<Integer>[] t = Set1.union(files);

        String[] para = args[2].split("\\,");
        int j = 0;
        FSet<Integer>[] res = new FSet[daSetArray.length];

        for (IntersectionFinder<Integer> seaLaOstia : daSetArray) {
            if (seaLaOstia != null) {
                res[j] = seaLaOstia.intersectSets(t);
                System.out.println( "Final Set By " + seaLaOstia.getName() + " " + seaLaOstia.intersectSets(t).toString() );
                j++;
            }
        }

        if ( para[0].equals("save") ) {
            saveMe(para[1], para[2], res);
        }
    }

    private static void saveMe(String path, String file,  FSet<Integer>[] res) throws FileNotFoundException {
        PrintWriter paramsFile = new PrintWriter(new File(path, file));

        for (FSet<Integer> i : res) {
            if (i != null)
                paramsFile.println("Final Set By " + i );
        }
        paramsFile.close();
    }

}