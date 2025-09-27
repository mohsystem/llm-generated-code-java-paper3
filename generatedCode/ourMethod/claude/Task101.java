package ourMethod.claude;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;

public class Task101 {
    public static void createExecutableScript(String filename) {
        try {
            // Create file with safe file handling
            File scriptFile = new File(filename);
            
            // Check if file already exists
            if(scriptFile.exists()) {
                throw new IOException("File already exists");
            }
            
            // Create new file
            try (FileWriter writer = new FileWriter(scriptFile)) {
                writer.write("#!/bin/bash\\n");
                writer.write("echo \\"Hello World\\"\\n");
            }

            // Set executable permissions
            Set<PosixFilePermission> perms = new HashSet<>();
            perms.add(PosixFilePermission.OWNER_READ);
            perms.add(PosixFilePermission.OWNER_WRITE); 
            perms.add(PosixFilePermission.OWNER_EXECUTE);
            
            Files.setPosixFilePermissions(scriptFile.toPath(), perms);

        } catch (IOException e) {
            System.err.println("Error creating script file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Test cases
        createExecutableScript("script.sh");
        createExecutableScript("test1.sh"); 
        createExecutableScript("test2.sh");
        createExecutableScript("test3.sh");
        createExecutableScript("test4.sh");
    }
}
