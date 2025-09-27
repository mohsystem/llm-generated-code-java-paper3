package ZeroShot.claude;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;

public class Task101 {
    public static void createExecutableScript(String content) {
        try {
            // Create file
            File scriptFile = new File("script.sh");
            FileWriter writer = new FileWriter(scriptFile);
            writer.write(content);
            writer.close();

            // Set executable permissions
            Set<PosixFilePermission> perms = new HashSet<>();
            perms.add(PosixFilePermission.OWNER_READ);
            perms.add(PosixFilePermission.OWNER_WRITE);
            perms.add(PosixFilePermission.OWNER_EXECUTE);
            Files.setPosixFilePermissions(scriptFile.toPath(), perms);

            System.out.println("Script file created and made executable successfully");
        } catch (IOException e) {
            System.err.println("Error creating script file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Test cases
        createExecutableScript("#!/bin/bash\\necho 'Hello World'");
        createExecutableScript("#!/bin/bash\\nls -la");
        createExecutableScript("#!/bin/bash\\ndate");
        createExecutableScript("#!/bin/bash\\npwd");
        createExecutableScript("#!/bin/bash\\nwhoami");
    }
}
