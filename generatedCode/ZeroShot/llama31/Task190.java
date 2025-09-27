package ZeroShot.llama31;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task190 {
    public static void main(String[] args) {
        String[] testFiles = {"file1.txt", "file2.txt", "file3.txt", "file4.txt", "file5.txt"};
        for (String file : testFiles) {
            transposeFile(file);
        }
    }

    public static void transposeFile(String inputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             FileWriter writer = new FileWriter("output_" + inputFile)) {

            List<String[]> rows = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                rows.add(line.split(" "));
            }

            int cols = rows.get(0).length;
            for (int col = 0; col < cols; col++) {
                for (String[] row : rows) {
                    writer.write(row[col] + " ");
                }
                writer.write("\n");
            }
        } catch (IOException e) {
            System.err.println("Error reading or writing file: " + e.getMessage());
        }
    }
}