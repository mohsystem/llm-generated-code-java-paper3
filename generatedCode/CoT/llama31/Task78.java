package CoT.llama31;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Task78 {
    public static void main(String[] args) {
        generateRSAKey("id_rsa", "id_rsa.pub");
    }

    public static void generateRSAKey(String privateKeyFile, String publicKeyFile) {
        try {
            Process process = Runtime.getRuntime().exec("ssh-keygen -t rsa -b 2048 -N \"\" -f " + privateKeyFile);
            process.waitFor();
            System.out.println("Private Key: " + new File(privateKeyFile).getAbsolutePath());
            System.out.println("Public Key: " + new File(publicKeyFile).getAbsolutePath());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}