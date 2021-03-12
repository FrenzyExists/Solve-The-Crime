package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import dataGenerator.DataGenerator;

public class FilesGeneratorMain {

    public static void generateFiles(int n, int m, int size) throws FileNotFoundException {
        File parentDirectory = new File("data-test");   // must exist in current directory
        DataGenerator dg = new DataGenerator(n, m, size);
        Object[][][] setsLists = dg.generateData();

        dg.printSizes();        // Print n, m and the size of each set
        dg.printSets();         // Print the freaking set

        PrintWriter paramsFile = new PrintWriter(new File(parentDirectory, "parameters.txt"));
        paramsFile.println(n);   // save parameter n
        paramsFile.println(m);   // save parameter m
        paramsFile.close();

        // create all the files for testing and grading with random integer values as
        // content. Each such file represents a set, since there is no repetition of
        // values. Some might end being empty...
        for (int i=0; i<n; i++)
            for (int j=0; j<m; j++) {
                String fileName = "F_" + i + "_" + j + ".txt";
                PrintWriter out = new PrintWriter(new File(parentDirectory, fileName));
                for (int k=0; k<setsLists[i][j].length; k++)
                    out.println(setsLists[i][j][k]);
                out.close();
            }


    }
}

