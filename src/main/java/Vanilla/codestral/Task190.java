package Vanilla.codestral;
import java.io.*;
import java.util.*;

public class Task190 {
    public static void main(String[] args) {
        transposeFile("file.txt");
    }

    public static void transposeFile(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            List<String[]> lines = new ArrayList<>();
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine().split(" "));
            }

            int rows = lines.size();
            int cols = lines.get(0).length;

            for (int i = 0; i < cols; i++) {
                for (int j = 0; j < rows; j++) {
                    System.out.print(lines.get(j)[i] + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}