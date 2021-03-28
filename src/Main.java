/*
@author: Angel L Garcia Guzman
Student ID: 802-17-6928
Course and Section: ICOM4020-086
 */

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

        String daPath = ""; // This will hold the parsed path
        IntersectionFinder<Integer>[] daSetArray = new IntersectionFinder[4];

        // Kill the process, the wrapper is encharged of the verbose
        if (args.length < 1)
            return;

        //
        if (!"default".equals(args[1])) {
            daPath = args[1];
        }


        // Get raw Data
        DataReader rawData;
        if (daPath.equals("")) {
            GenerateMain.main(new String[]{"10", "10", "10"});
            rawData = new DataReader();
        }
        else {
            rawData = new DataReader(daPath);
        }

        // Parse arguments from wrapper
        switch (args[0]) {
            case "p1" -> daSetArray[0] = new AlfaBeta<>("P1");
            case "p2" -> daSetArray[1] = new AlfaBeta<>("P2");
            case "p3" -> daSetArray[2] = new Delta<>();
            case "p4" -> daSetArray[3] = new Yakama<>();
            case "all" -> {
                daSetArray[0] = new AlfaBeta<>("P1");
                daSetArray[1] = new AlfaBeta<>("P2");
                daSetArray[2] = new Delta<>();
                daSetArray[3] = new Yakama<>();
            }
        }

        // Read Raw data
        Object[][][] files = rawData.readDataFiles();

        // Get Union of raw data
        FSet<Integer>[] t = Set1.union(files);

        // Parse additional Params
        String[] para = args[2].split("\\,");
        int j = 0;
        FSet<Integer>[] res = new FSet[daSetArray.length];

        // Parse Intersects Implementations to console
        for (IntersectionFinder<Integer> technique : daSetArray) {
            if (technique != null) {
                res[j] = technique.intersectSets(t);
                System.out.println( "Final Set By " + technique.getName() + " " + technique.intersectSets(t).toString() );
                j++;
            }
        }

        if ( para[0].equals("save") ) {
            saveMe(para[1], para[2], res);
        }
    }

    // Save intersection to a file, just in case
    private static void saveMe(String path, String file,  FSet<Integer>[] res) throws FileNotFoundException {
        PrintWriter paramsFile = new PrintWriter(new File(path, file));

        for (FSet<Integer> i : res) {
            if (i != null)
                paramsFile.println("Final Set By " + i );
        }
        paramsFile.close();
    }
}
