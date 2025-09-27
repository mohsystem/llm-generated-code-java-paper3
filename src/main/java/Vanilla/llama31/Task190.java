package Vanilla.llama31;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Task190 {
    public static void transposeFile(String inputFile, String outputFile) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             FileWriter writer = new FileWriter(outputFile)) {

            String line;
            String[] columns = null;
            int numColumns = 0;

            while ((line = reader.readLine()) != null) {
                String[] row = line.split(" ");
                if (columns == null) {
                    numColumns = row.length;
                    columns = new String[numColumns];
                }
                for (int i = 0; i < numColumns; i++) {
                    columns[i] += (columns[i] == null ? "" : " ") + row[i];
                }
            }

            for (String column : columns) {
                writer.write(column + "\n");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // Test cases
        transposeFile("file.txt", "output.txt");
        // Additional test cases can be added here
    }
}