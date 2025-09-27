package CoT.llama31;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Task190 {
    public static void main(String[] args) {
        String[] testFiles = {"file1.txt", "file2.txt", "file3.txt", "file4.txt", "file5.txt"};
        for (String file : testFiles) {
            transposeFile(file);
        }
    }

    public static void transposeFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName));
             FileWriter fw = new FileWriter("output_" + fileName)) {

            String line;
            String[] rows = new String[0];
            while ((line = br.readLine()) != null) {
                rows = addRow(rows, line);
            }

            int numCols = rows[0].split(" ").length;
            for (int col = 0; col < numCols; col++) {
                for (String row : rows) {
                    String[] fields = row.split(" ");
                    fw.write(fields[col] + " ");
                }
                fw.write("\n");
            }

        } catch (IOException e) {
            System.err.println("Error reading or writing file: " + e.getMessage());
        }
    }

    private static String[] addRow(String[] rows, String newRow) {
        String[] newRows = new String[rows.length + 1];
        System.arraycopy(rows, 0, newRows, 0, rows.length);
        newRows[rows.length] = newRow;
        return newRows;
    }
}