package Vanilla.gemini;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;

public class Task101 {
    public static void createExecutableScript(String fileName) throws IOException {
        Files.createFile(Paths.get(fileName));

        Set<PosixFilePermission> perms = new HashSet<>();
        perms.add(PosixFilePermission.OWNER_READ);
        perms.add(PosixFilePermission.OWNER_WRITE);
        perms.add(PosixFilePermission.OWNER_EXECUTE);

        Files.setPosixFilePermissions(Paths.get(fileName), perms);
    }

    public static void main(String[] args) throws IOException {
        createExecutableScript("script.sh");
        createExecutableScript("script1.sh");
        createExecutableScript("script2.sh");
        createExecutableScript("script3.sh");
        createExecutableScript("script4.sh");
    }
}