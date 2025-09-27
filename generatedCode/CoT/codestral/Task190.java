package CoT.codestral;
import java.io.*;
import java.util.*;

public class Task190 {
    public static void transposeFile(String filename) throws IOException {
        List<String[]> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line.split(" "));
            }
        }

        for (int i = 0; i < lines.get(0).length; i++) {
            for (String[] line : lines) {
                System.out.print(line[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        transposeFile("file.txt");
    }
}