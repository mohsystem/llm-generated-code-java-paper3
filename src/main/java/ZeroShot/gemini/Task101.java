package ZeroShot.gemini;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;

public class Task101 {
    public static void createExecutableScript(String filename, String content) throws IOException {
        Files.writeString(Paths.get(filename), content);

        Set<PosixFilePermission> perms = new HashSet<>();
        perms.add(PosixFilePermission.OWNER_READ);
        perms.add(PosixFilePermission.OWNER_WRITE);
        perms.add(PosixFilePermission.OWNER_EXECUTE);
        perms.add(PosixFilePermission.GROUP_READ);
        perms.add(PosixFilePermission.OTHERS_READ);

        Files.setPosixFilePermissions(Paths.get(filename), perms);
    }

    public static void main(String[] args) throws IOException {
        createExecutableScript("script.sh", "#/bin/bash\necho \"Hello, World\"\n");
        createExecutableScript("script1.sh", "#/bin/bash\necho \"Test 1\"\n");
        createExecutableScript("script2.sh", "#/bin/bash\necho \"Test 2\"\n");
        createExecutableScript("script3.sh", "#/bin/bash\necho \"Test 3\"\n");
        createExecutableScript("script4.sh", "#/bin/bash\necho \"Test 4\"\n");

    }
}