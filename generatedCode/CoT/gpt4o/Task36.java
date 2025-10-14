package CoT.openai;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task36 {
    public static void readFileAndPrint(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        readFileAndPrint("test1.txt");
        readFileAndPrint("test2.txt");
        readFileAndPrint("test3.txt");
        readFileAndPrint("test4.txt");
        readFileAndPrint("test5.txt");
    }
}