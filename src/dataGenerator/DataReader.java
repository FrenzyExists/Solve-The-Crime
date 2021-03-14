package dataGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author pedroirivera-vega
 *
 */
public class DataReader {

    private int n;    // number of data generators (telephone companies in p1_4035_4020_172
    private int m;    // number of data sets produced per data generator
    private Integer[][][] dataSet;
    private String parentDirectory;

    public DataReader() throws FileNotFoundException {
        String defaultDirectory = "data-test";
        this.DataBuilder(defaultDirectory);
    }

    public DataReader(String path) throws FileNotFoundException{
        this.DataBuilder(path);
    }

    private void DataBuilder(String path) throws FileNotFoundException {
        parentDirectory = path;
        Scanner parameters = new Scanner(new File(parentDirectory, "parameters.txt"));
        this.n = parameters.nextInt();
        this.m = parameters.nextInt();
        parameters.close();
    }

    /**
     *
     * @return Object[][][] MultiArray
     * @throws FileNotFoundException Either its a faulty path or the path does not contain files following the standard
     */
    public Object[][][] readDataFiles() throws FileNotFoundException {
        dataSet = new Integer[n][m][];

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {

                String fileName = "F_" + i + "_" + j + ".txt";
                Scanner inputFile = new Scanner(new File(parentDirectory, fileName));
                ArrayList<Integer> fileContent = new ArrayList<>();
                while (inputFile.hasNext())
                    fileContent.add(inputFile.nextInt());
                inputFile.close();
                dataSet[i][j] = (Integer[]) fileContent.toArray(new Integer[0]);
            }
        }
        return dataSet;
    }

    private void printArray(Integer[] numbers) {
        for (int i=0; i<numbers.length; i++)
            System.out.print(numbers[i] + "  ");
        System.out.println();
    }
}

