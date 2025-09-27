package ZeroShot.codestral;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task119 {
    public static List<String[]> parseCSV(String filename) throws IOException {
        List<String[]> result = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            result.add(values);
        }
        br.close();
        return result;
    }

    public static void main(String[] args) {
        try {
            List<String[]> data = parseCSV("example.csv");
            for (String[] row : data) {
                for (String value : row) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}