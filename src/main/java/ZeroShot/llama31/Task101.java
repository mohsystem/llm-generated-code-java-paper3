package ZeroShot.llama31;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Task101 {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Create the script file
        try (PrintWriter out = new PrintWriter(new FileWriter("script.sh"))) {
            out.println("#!/bin/bash");
            out.println("echo 'Hello World'");
        }

        // Make the script executable using a shell command
        ProcessBuilder pb = new ProcessBuilder("chmod", "+x", "script.sh");
        pb.start().waitFor();

        // Test cases
        for (int i = 0; i < 5; i++) {
            ProcessBuilder pbRun = new ProcessBuilder("./script.sh");
            pbRun.start().waitFor();
        }
    }
}