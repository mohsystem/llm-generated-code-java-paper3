package ourMethod.llama31;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task52 {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String encryptedFile = "encrypted.txt";
        String decryptedFile = "decrypted.txt";
        int key = 3;

        encryptFile(inputFile, encryptedFile, key);
        decryptFile(encryptedFile, decryptedFile, key);
    }

    public static void encryptFile(String inputFile, String outputFile, int key) {
        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile)) {

            int ch;
            while ((ch = fis.read()) != -1) {
                fos.write((char) (ch + key));
            }
            System.out.println("File encrypted successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void decryptFile(String inputFile, String outputFile, int key) {
        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile)) {

            int ch;
            while ((ch = fis.read()) != -1) {
                fos.write((char) (ch - key));
            }
            System.out.println("File decrypted successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}