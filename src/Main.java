import dataGenerator.DataReader;
import insersections.*;
import interfases.FSet;
import setImplementations.Set1;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

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


        DataReader test = new DataReader(daPath);
        Object[][][] files = test.readDataFiles();

        FSet<Integer>[] t = Set1.union(files);

        for (IntersectionFinder<Integer> seaLaOstia : daSetArray) {
            if (seaLaOstia != null) {
                System.out.println( "Final Set By " + seaLaOstia.getName() + " " + seaLaOstia.intersectSets(t).toString() );
            }
        }

        System.out.println("AQUI");
        String[] para = args[2].split("\\,");



        System.out.println("AQUI");


        // Are we checking a single folder with
        Path child = Paths.get("daPath").toAbsolutePath();
//        if ( isChild(child, daPath) ) {
//
//
//        }


    }

    private static boolean isChild(Path child, String parentText) {
        Path parent = Paths.get(parentText).toAbsolutePath();
        return child.startsWith(parent);
    }

    private static void saveMe(Path saveHere, IntersectionFinder<Integer> res) {

    }


}