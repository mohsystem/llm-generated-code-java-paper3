package ourMethod.gemini;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;

public class Task101 {

    public static void createAndMakeExecutable(String filename) throws IOException {
        Files.createFile(Paths.get(filename));
        Set<PosixFilePermission> perms = new HashSet<>();
        perms.add(PosixFilePermission.OWNER_READ);
        perms.add(PosixFilePermission.OWNER_WRITE);
        perms.add(PosixFilePermission.OWNER_EXECUTE);
        perms.add(PosixFilePermission.GROUP_READ);
        perms.add(PosixFilePermission.OTHERS_READ);
        Files.setPosixFilePermissions(Paths.get(filename), perms);
    }

    public static void main(String[] args) throws IOException {
        createAndMakeExecutable("script1.sh");
        createAndMakeExecutable("script2.sh");
        createAndMakeExecutable("script3.sh");
        createAndMakeExecutable("script4.sh");
        createAndMakeExecutable("script5.sh");
        System.out.println("Files created and made executable.");
    }
}