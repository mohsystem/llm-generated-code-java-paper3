package ZeroShot.codestral;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task190 {
    public static void transposeFile(String fileName) {
        List<List<String>> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(" ");
                for (int i = 0; i < values.length; i++) {
                    if (i >= lines.size()) {
                        lines.add(new ArrayList<>());
                    }
                    lines.get(i).add(values[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (List<String> line : lines) {
            for (String value : line) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        transposeFile("file.txt");
    }
}