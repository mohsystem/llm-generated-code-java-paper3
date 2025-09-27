package Vanilla.llama31;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task36 {
    public static void main(String[] args) {
        String[] testCases = {"filename1.txt", "filename2.txt", "filename3.txt", "filename4.txt", "filename5.txt"};
        for (String testCase : testCases) {
            readAndPrintFile(testCase);
        }
    }

    public static void readAndPrintFile(String filename) {
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred: File not found.");
            e.printStackTrace();
        }
    }
}