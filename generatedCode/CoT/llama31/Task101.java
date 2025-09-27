package CoT.llama31;
import java.io.FileWriter;
import java.io.IOException;

public class Task101 {
    public static void main(String[] args) {
        try {
            // Create the script file
            FileWriter writer = new FileWriter("script.sh");
            writer.write("#!/bin/bash\n");
            writer.write("echo 'Hello World'\n");
            writer.close();

            // Make the script executable
            Runtime.getRuntime().exec("chmod +x script.sh");
        } catch (IOException e) {
            System.out.println("Error creating or writing to the file: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error making the script executable: " + e.getMessage());
        }
    }
}