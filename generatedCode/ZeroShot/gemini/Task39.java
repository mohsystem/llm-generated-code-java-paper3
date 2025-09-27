package ZeroShot.gemini;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Task39 {
    public static String displayFileContents(String filename) throws IOException {
        String command = "cat " + filename; // Use cat command for simplicity
        Process process = Runtime.getRuntime().exec(command);

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }

        int exitCode = process.waitFor();
        if (exitCode != 0) {
            throw new IOException("Error executing command: " + exitCode);
        }

        return output.toString();

    }

    public static void main(String[] args) {
        try {
            System.out.println(displayFileContents("test1.txt"));
            System.out.println(displayFileContents("test2.txt"));
            System.out.println(displayFileContents("test3.txt"));
            System.out.println(displayFileContents("test4.txt"));
            System.out.println(displayFileContents("test5.txt"));

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}