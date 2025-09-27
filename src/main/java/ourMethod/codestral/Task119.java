package ourMethod.codestral;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task119 {
    public static void parseCSV(String filePath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            for (String value : values) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
        br.close();
    }

    public static void main(String[] args) {
        try {
            parseCSV("test1.csv");
            parseCSV("test2.csv");
            parseCSV("test3.csv");
            parseCSV("test4.csv");
            parseCSV("test5.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}