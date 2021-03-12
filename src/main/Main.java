package main;


import dataGenerator.DataReader;
import interfases.FSet;
import setImplementations.Set1;
import setImplementations.Set2;
import solutionMethods.Alfa;
import solutionMethods.Beta;
import solutionMethods.Delta;
import solutionMethods.Yakama;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Set;


public class Main {

    // This is where things start... This initializes everything
    public static void main(String[] args) throws FileNotFoundException, CloneNotSupportedException {
        System.out.println(String.join("\n", "" +
                        "  ____   ___  _ __     _______   ____    _      _____ _   _  ____ _  _____ _   _  ____    ____ ____  ___ __  __ _____ ",
                " / ___| / _ \\| |\\ \\   / / ____| |  _ \\  / \\    |  ___| | | |/ ___| |/ /_ _| \\ | |/ ___|  / ___|  _ \\|_ _|  \\/  | ____|",
                " \\___ \\| | | | | \\ \\ / /|  _|   | | | |/ _ \\   | |_  | | | | |   | ' / | ||  \\| | |  _  | |   | |_) || || |\\/| |  _|  ",
                "  ___) | |_| | |__\\ V / | |___  | |_| / ___ \\  |  _| | |_| | |___| . \\ | || |\\  | |_| | | |___|  _ < | || |  | | |___ ",
                " |____/ \\___/|_____\\_/  |_____| |____/_/   \\_\\ |_|    \\___/ \\____|_|\\_\\___|_| \\_|\\____|  \\____|_| \\_\\___|_|  |_|_____|"
        ));
        System.out.println("version 0.1: Bitch Lasagna");

        System.out.println(String.join("\n",
                "Options:" +
                        "\n",
                "--path-of-data  -- parse the path of the folder containing the data (F_i_j.txt)",
                "--method        -- choose one of 4 available methods: p1, p2, p3, p4",
                "-s              -- save data to we_caught_the_mtherfker.txt",
                "-v              -- verbose aka print input data and solved data",
                "-t              -- display time of used method",
                "-h              -- display this help and exit"
        ));

        // Test ///////////////////////////////////////////////////////

        DataReader test = new DataReader();
        Object[][][] files = test.readDataFiles();

        /**
         * for j = 0 -> m:
         *     * create T_j
         *     for i = 0 ->
         *         * add unique elements to T_j
         *      * Add T_j to the array of sets
         */

        int n = files.length;
        int m = files[0].length;
        int counter = 0;

        FSet<Object>[] t = new Set1[m];

        for (int j=0 ; j<m ; j++) {
            FSet<Object> ti = new Set1<>();
            for (int i=0 ; i < n ; i++) {
                for (Object k : files[i][j]) {
                    ti.add(k);
                }
            }
            t[counter] = ti;
            counter++;
        }


//        IntersectionFinder P1 = new Alfa();
//        P1.intersectSets(t);
//
//        IntersectionFinder P2 = new Beta();
//        P2.intersectSets(t);
//
//        IntersectionFinder P3 = new Delta();
//        P3.intersectSets(t);

        IntersectionFinder P4 = new Yakama();
        P4.intersectSets(t);




    }
}

/*
//        if (args.length <= 3) {
//            int n = 20;
//            int m = 50;
//            int size = 50000;
//            if (args.length >= 1)
//                n = Integer.parseInt(args[0]);
//            if (args.length >= 2)
//                m = Integer.parseInt(args[1]);
//            if (args.length == 3)
//                size = Integer.parseInt(args[2]);
//            FilesGeneratorMain.generateFiles(n, m, size);
//        }
//        else
//            System.out.println("Invalid number of parameters. Must be <= 2.");

        System.out.println("\n\nOk, so as you can see, these are the files I gonna work on, its kinda of a simulation of " +
                "what a company would give me, sort of.\nAnyway, my job is to kind the phone number of thieves, at " +
                "least theoretically. Anyway just let me work a sec-");


        DataReader dr = new DataReader();
        Object[][][] data = dr.readDataFiles();
        System.out.println(data.length);

        //Sets
        dr.printSets();


        System.out.println("P1");
        IntersectionFinder P1 = new Delta();
//        P1.intersectSets()

//        System.out.println("P2");

//        System.out.println("P3");

//        System.out.println("P4");









        for (int i=0; i<files.length; i++) {
            for (int j=0; j<files[i].length; j++) {
                for (Object k : files[i][j]) {
                    System.out.print(k + " ");
                }
                System.out.println("\n");
            }
            System.out.println("\n\n");
        }






        FSet[] F = new FSet[files.length*files[0].length];
        int counter = 0;

        for (int i = 0; i < files.length; i++) {
            for (int j = 0; j < files[i].length; j++) {
                FSet<Object> temp = new Set1<>();
                for (int k = 0; k < files[i][j].length; k++) {
                    temp.add(files[i][j][k]);
                }
                F[counter] = temp;
                counter++;
            }
        }
        Alfa P1 = new Alfa();
        P1.intersectSets(F);



        Beta P2 = new Beta();
        P2.intersectSets(F);



 */

