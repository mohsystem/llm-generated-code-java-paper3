package Vanilla.llama31;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Task52 {
    public static void main(String[] args) throws Exception {
        String inputFile = "input.txt";
        String encryptedFile = "encrypted.txt";
        String decryptedFile = "decrypted.txt";
        String keyFile = "key.txt";

        // Generate a key
        SecretKey key = generateKey();
        saveKey(key, keyFile);

        // Encrypt the file
        encryptFile(inputFile, encryptedFile, key);

        // Decrypt the file
        decryptFile(encryptedFile, decryptedFile, key);

        // Test cases
        testCases(key);
    }

    public static SecretKey generateKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // 128-bit key
        return keyGen.generateKey();
    }

    public static void saveKey(SecretKey key, String fileName) throws IOException {
        byte[] keyBytes = key.getEncoded();
        FileOutputStream fos = new FileOutputStream(fileName);
        fos.write(keyBytes);
        fos.close();
    }

    public static SecretKey loadKey(String fileName) throws IOException {
        FileInputStream fis = new FileInputStream(fileName);
        byte[] keyBytes = new byte[16]; // 128-bit key
        fis.read(keyBytes);
        fis.close();
        return new SecretKeySpec(keyBytes, "AES");
    }

    public static void encryptFile(String inputFile, String outputFile, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        encryptDecryptFile(cipher, inputFile, outputFile);
    }

    public static void decryptFile(String inputFile, String outputFile, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        encryptDecryptFile(cipher, inputFile, outputFile);
    }

    public static void encryptDecryptFile(Cipher cipher, String inputFile, String outputFile) throws Exception {
        FileInputStream fis = new FileInputStream(inputFile);
        FileOutputStream fos = new FileOutputStream(outputFile);
        byte[] buffer = new byte[64];
        int bytesRead;
        while ((bytesRead = fis.read(buffer)) != -1) {
            byte[] output = cipher.update(buffer, 0, bytesRead);
            if (output != null) {
                fos.write(output);
            }
        }
        byte[] output = cipher.doFinal();
        if (output != null) {
            fos.write(output);
        }
        fis.close();
        fos.close();
    }

    public static void testCases(SecretKey key) throws Exception {
        String[] inputFiles = {"test1.txt", "test2.txt", "test3.txt", "test4.txt", "test5.txt"};
        String[] encryptedFiles = {"test1_enc.txt", "test2_enc.txt", "test3_enc.txt", "test4_enc.txt", "test5_enc.txt"};
        String[] decryptedFiles = {"test1_dec.txt", "test2_dec.txt", "test3_dec.txt", "test4_dec.txt", "test5_dec.txt"};

        for (int i = 0; i < 5; i++) {
            encryptFile(inputFiles[i], encryptedFiles[i], key);
            decryptFile(encryptedFiles[i], decryptedFiles[i], key);
        }
    }
}