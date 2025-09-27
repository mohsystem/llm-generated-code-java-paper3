package CoT.llama31;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task52 {
    public static void encryptFile(String inputFile, String outputFile, int key) throws IOException {
        File inFile = new File(inputFile);
        File outFile = new File(outputFile);
        FileInputStream fin = new FileInputStream(inFile);
        FileOutputStream fout = new FileOutputStream(outFile);

        int c;
        while ((c = fin.read()) != -1) {
            fout.write((char) (c + key));
        }
        fin.close();
        fout.close();
    }

    public static void decryptFile(String inputFile, String outputFile, int key) throws IOException {
        File inFile = new File(inputFile);
        File outFile = new File(outputFile);
        FileInputStream fin = new FileInputStream(inFile);
        FileOutputStream fout = new FileOutputStream(outFile);

        int c;
        while ((c = fin.read()) != -1) {
            fout.write((char) (c - key));
        }
        fin.close();
        fout.close();
    }

    public static void main(String[] args) throws IOException {
        // Test cases
        String inputFile = "input.txt";
        String encryptedFile = "encrypted.txt";
        String decryptedFile = "decrypted.txt";
        int key = 3;

        encryptFile(inputFile, encryptedFile, key);
        decryptFile(encryptedFile, decryptedFile, key);
    }
}