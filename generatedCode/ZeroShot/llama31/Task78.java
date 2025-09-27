package ZeroShot.llama31;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Task78 {
    public static void main(String[] args) {
        generateSSHKey("id_rsa");
    }

    public static void generateSSHKey(String keyName) {
        try {
            Process process = Runtime.getRuntime().exec(new String[] {"ssh-keygen", "-t", "rsa", "-b", "2048", "-f", keyName, "-N", ""});
            process.waitFor();
            System.out.println("Private key saved to " + keyName);
            System.out.println("Public key saved to " + keyName + ".pub");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}