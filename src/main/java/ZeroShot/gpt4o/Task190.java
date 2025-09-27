package ZeroShot.gpt4o;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task190 {
    public static List<String> transposeFile(String filename) {
        List<String> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            List<String[]> lines = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line.split(" "));
            }
            if (!lines.isEmpty()) {
                int rowCount = lines.size();
                int colCount = lines.get(0).length;
                for (int i = 0; i < colCount; i++) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < rowCount; j++) {
                        if (j > 0) sb.append(" ");
                        sb.append(lines.get(j)[i]);
                    }
                    result.add(sb.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public static void main(String[] args) {
        String testFile = "file.txt";
        List<String> output = transposeFile(testFile);
        for (String line : output) {
            System.out.println(line);
        }
    }
}