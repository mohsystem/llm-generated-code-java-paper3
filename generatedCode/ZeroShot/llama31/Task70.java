package ZeroShot.llama31;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task70 {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide the file path as a command line argument.");
            return;
        }
        String filePath = args[0];
        readAndPrintFileContent(filePath);
    }

    public static void readAndPrintFileContent(String filePath) {
        try {
            File myObj = new File(filePath);
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

    public static void mainTest() {
        String[] testCases = {"test1.txt", "test2.txt", "test3.txt", "test4.txt", "test5.txt"};
        for (String testCase : testCases) {
            System.out.println("Reading file: " + testCase);
            readAndPrintFileContent(testCase);
            System.out.println();
        }
    }
}