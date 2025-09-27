package ourMethod.llama31;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task190 {
    public static void main(String[] args) {
        transposeFile("file.txt");
    }

    public static void transposeFile(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            String[] lines = scanner.useDelimiter("\\Z").next().split("\n");
            scanner.close();

            String[][] matrix = new String[lines.length][];
            for (int i = 0; i < lines.length; i++) {
                matrix[i] = lines[i].split(" ");
            }

            // Transpose the matrix
            String[][] transposedMatrix = new String[matrix[0].length][matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    transposedMatrix[j][i] = matrix[i][j];
                }
            }

            // Print the transposed matrix
            for (String[] row : transposedMatrix) {
                for (String element : row) {
                    System.out.print(element + " ");
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}