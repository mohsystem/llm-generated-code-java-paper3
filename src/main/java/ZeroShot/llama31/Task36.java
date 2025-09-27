package ZeroShot.llama31;
import java.util.Scanner;
import java.io.*;

public class Task36 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter the Name of File: ");
            String fname = scan.nextLine();
            readAndPrintFile(fname);
        }
        scan.close();
    }

    public static void readAndPrintFile(String fname) {
        try {
            FileReader fileReader = new FileReader(fname);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (IOException ex) {
            System.out.println("\nError occurred");
            System.out.println("Exception Name: " + ex);
        }
    }
}