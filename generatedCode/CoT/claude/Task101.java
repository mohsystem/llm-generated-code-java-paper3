package CoT.claude;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;

public class Task101 {
    public static boolean createExecutableScript(String content) {
        try {
            // Create file
            File scriptFile = new File("script.sh");
            if (!scriptFile.createNewFile()) {
                System.out.println("File already exists");
                return false;
            }

            // Write content
            try (FileWriter writer = new FileWriter(scriptFile)) {
                writer.write(content);
            }

            // Set executable permissions
            Set<PosixFilePermission> perms = new HashSet<>();
            perms.add(PosixFilePermission.OWNER_READ);
            perms.add(PosixFilePermission.OWNER_WRITE);
            perms.add(PosixFilePermission.OWNER_EXECUTE);
            Files.setPosixFilePermissions(scriptFile.toPath(), perms);
            
            return true;
        } catch (IOException e) {
            System.out.println("Error creating executable script: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] testContents = {
            "#!/bin/bash\\necho 'Hello World'",
            "#!/bin/bash\\nls -la",
            "#!/bin/bash\\ndate",
            "#!/bin/bash\\npwd",
            "#!/bin/bash\\nwhoami"
        };

        for (int i = 0; i < testContents.length; i++) {
            System.out.println("Test case " + (i + 1) + ":");
            boolean result = createExecutableScript(testContents[i]);
            System.out.println("Result: " + result + "\\n");
        }
    }
}
