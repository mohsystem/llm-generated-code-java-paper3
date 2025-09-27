package Vanilla.codestral;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task70 {
    public static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = br.readLine()) != null) {
            content.append(line).append("\n");
        }
        br.close();
        return content.toString();
    }

    public static void main(String[] args) {
        try {
            System.out.println(readFile(args[0]));
            System.out.println(readFile(args[1]));
            System.out.println(readFile(args[2]));
            System.out.println(readFile(args[3]));
            System.out.println(readFile(args[4]));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}