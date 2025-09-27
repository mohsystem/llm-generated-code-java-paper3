package Vanilla.claude;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Task101 {
    public static boolean createExecutableScript() {
        try {
            // Create file
            File scriptFile = new File("script.sh");
            FileWriter writer = new FileWriter(scriptFile);
            writer.write("#!/bin/bash\\necho \"Hello from script\"");
            writer.close();
            
            // Make executable
            return scriptFile.setExecutable(true);
        } catch (IOException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        // Test case 1: Create new script file
        System.out.println("Test 1: " + createExecutableScript());
        
        // Test case 2: Create script file again (overwrite)
        System.out.println("Test 2: " + createExecutableScript());
        
        // Test case 3: Verify file exists
        System.out.println("Test 3: " + new File("script.sh").exists());
        
        // Test case 4: Verify file is executable
        System.out.println("Test 4: " + new File("script.sh").canExecute());
        
        // Test case 5: Create script in invalid location
        new File("script.sh").setWritable(false);
        System.out.println("Test 5: " + createExecutableScript());
    }
}
