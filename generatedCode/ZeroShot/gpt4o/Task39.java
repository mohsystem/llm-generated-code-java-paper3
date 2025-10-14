package ZeroShot.openai;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task39 {
    public static String readFileContents(String filename) {
        StringBuilder output = new StringBuilder();
        try {
            ProcessBuilder pb = new ProcessBuilder("cat", filename);
            Process process = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            reader.close();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return output.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(readFileContents("testfile1.txt"));
        System.out.println(readFileContents("testfile2.txt"));
        System.out.println(readFileContents("testfile3.txt"));
        System.out.println(readFileContents("testfile4.txt"));
        System.out.println(readFileContents("testfile5.txt"));
    }
}