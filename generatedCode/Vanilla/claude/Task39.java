package Vanilla.claude;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Task39 {
    public static String displayFileContents(String filename) {
        StringBuilder output = new StringBuilder();
        try {
            Process process;
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                process = Runtime.getRuntime().exec("type " + filename);
            } else {
                process = Runtime.getRuntime().exec("cat " + filename);
            }
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            reader.close();
        } catch (Exception e) {
            return "Error reading file: " + e.getMessage();
        }
        return output.toString();
    }

    public static void main(String[] args) {
        // Test cases
        String[] testFiles = {
            "test1.txt",
            "sample.txt", 
            "nonexistent.txt",
            "data.txt",
            "empty.txt"
        };
        
        for(String file : testFiles) {
            System.out.println("Reading file: " + file);
            System.out.println(displayFileContents(file));
            System.out.println("------------------------");
        }
    }
}
