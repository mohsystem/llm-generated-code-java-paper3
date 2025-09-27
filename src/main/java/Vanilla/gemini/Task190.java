package Vanilla.gemini;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task190 {

    public static String transposeFile(String filePath) throws IOException {
        List<String[]> rows = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                rows.add(line.split(" "));
            }
        }

        StringBuilder sb = new StringBuilder();
        int numRows = rows.size();
        int numCols = rows.get(0).length;

        for (int j = 0; j < numCols; j++) {
            for (int i = 0; i < numRows; i++) {
                sb.append(rows.get(i)[j]);
                if (i < numRows - 1) {
                    sb.append(" ");
                }
            }
            if (j < numCols - 1) {
                sb.append("\n");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(transposeFile("file1.txt"));
        System.out.println(transposeFile("file2.txt"));
        System.out.println(transposeFile("file3.txt"));
        System.out.println(transposeFile("file4.txt"));
        System.out.println(transposeFile("file5.txt"));

    }
}