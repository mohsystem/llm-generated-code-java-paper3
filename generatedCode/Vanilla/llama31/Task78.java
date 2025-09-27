package Vanilla.llama31;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task78 {
    public static void main(String[] args) {
        generateRSAKey();
    }

    public static void generateRSAKey() {
        try {
            Process process = Runtime.getRuntime().exec("ssh-keygen -t rsa -N '' -f ~/.ssh/id_rsa");
            process.waitFor();
            System.out.println("RSA key generated successfully.");
        } catch (IOException | InterruptedException e) {
            System.err.println("Error generating RSA key: " + e.getMessage());
        }
    }
}