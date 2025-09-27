package Vanilla.llama31;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task129 {
    public static void main(String[] args) {
        // Test cases
        String[] inputFiles = {"input1.txt", "input2.txt", "input3.txt", "input4.txt", "input5.txt"};
        String[] outputFiles = {"output1.txt", "output2.txt", "output3.txt", "output4.txt", "output5.txt"};

        for (int i = 0; i < 5; i++) {
            processFile(inputFiles[i], outputFiles[i]);
        }
    }

    public static void processFile(String inputFile, String outputFile) {
        try (Scanner scanner = new Scanner(new File(inputFile));
             FileWriter writer = new FileWriter(outputFile)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                writer.write(line + "\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found: " + inputFile);
        } catch (IOException e) {
            System.out.println("Error writing to output file: " + outputFile);
        }
    }
}