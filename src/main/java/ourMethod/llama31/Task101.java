package ourMethod.llama31;
import java.io.FileWriter;
import java.io.IOException;

public class Task101 {
    public static void main(String[] args) throws IOException {
        try (FileWriter writer = new FileWriter("script.sh")) {
            writer.write("#!/bin/bash\n");
            writer.write("echo 'Hello World'\n");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        // Make the script executable
        Runtime.getRuntime().exec("chmod +x script.sh");
    }
}