import dataGenerator.DataReader;
import insersections.*;
import interfases.FSet;
import setImplementations.Set1;

import java.io.FileNotFoundException;


public class Main {


    // This is where things start... This initializes everything
    public static void main(String[] args) throws FileNotFoundException, CloneNotSupportedException {






        int parm = 0;

        if (args.length < 1)
            return;

//        System.out.println(args[1]);

        for (String i : args)
            System.out.println(i);
        System.out.println("\n");

        switch (args[0]) {

            case "p1":
                System.out.println("P1");
                break;
            case "p2":
                System.out.println("P2");
                break;
            case "p3":
                System.out.println("P3");
                break;
            case "p4":
                System.out.println("P3");
                break;
            case "all":
                System.out.println("P1P2P3P4");

                break;
        }

//        switch (args[1]) {
//            case "default":
//                System.out.println("IT WORKS");
//                break;
//        }

//        switch (args[2]) {
//            case "":
//                ;
//        }



    }

    private static String concat(String[] args) {
        String result = "";
        for (String arg : args) {
            result += arg;
        }
        return result;
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