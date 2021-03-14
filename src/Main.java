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


        if (args.length < 1)
            return;

        System.out.println(args.length);
        for (String i : args)
            System.out.println(i);
        System.out.println("\n");


        switch (args[1]) {
            case "default":
                daPath = "";
                break;
            default :
                daPath = args[1];
        }

//        switch (args[2]) {
//            case "":
//                ;
//        }

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
                System.out.println( seaLaOstia.intersectSets(t).toString() );
            }

        }



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


}



/**
 int parm = 0;
 if (args.length > 1) {
 System.out.println("Unexpected number of parameters. Must be <= 1.");
 return;
 }
 if (args.length == 1)
 parm = Integer.parseInt(args[0]);

 DataReader dr = new DataReader();
 Object[][][] setsLists = dr.readDataFiles(); // see above comments about this method

 if (parm == 0 || parm == 1)
 ... apply the strategy of P1 to find the intersection the corresponding sets...
 if (parm == 0 || parm == 2)
 ... apply the strategy of P2 to find the intersection the corresponding sets...
 if (parm == 0 || parm == 3)
 ... apply the strategy of P3 to find the intersection the corresponding sets...
 if (parm == 0 || parm == 4)
 ... apply the strategy of P4 to find the intersection the corresponding sets...
 */

/**
 // Test ///////////////////////////////////////////////////////

 DataReader test = new DataReader("testCases/inputFiles_6");
 Object[][][] files = test.readDataFiles();

 FSet<Object>[] t = Set1.union(files);

 for (FSet i : t) {
 System.out.println(i);
 }
 //        System.out.println("\n\n");


 IntersectionFinder P1 = new Alfa();
 System.out.println(P1.intersectSets(t));
 //
 IntersectionFinder P2 = new Beta();
 System.out.println(P2.intersectSets(t));

 IntersectionFinder P3 = new Delta();
 System.out.println(P3.intersectSets(t));
 //
 IntersectionFinder P4 = new Yakama();

 System.out.println(P4.intersectSets(t));




 */