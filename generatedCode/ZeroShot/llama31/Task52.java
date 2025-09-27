package ZeroShot.llama31;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class Task52 {
    public static void main(String[] args) throws Exception {
        // Test cases
        String[] files = {"file1.txt", "file2.txt", "file3.txt", "file4.txt", "file5.txt"};
        for (String file : files) {
            encryptFile(file, "encrypted_" + file);
            decryptFile("encrypted_" + file, "decrypted_" + file);
        }
    }

    public static void encryptFile(String inputFile, String outputFile) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // 128-bit key
        SecretKey secretKey = keyGen.generateKey();
        byte[] keyBytes = secretKey.getEncoded();

        // Save the key for decryption
        try (FileOutputStream fos = new FileOutputStream("key.key")) {
            fos.write(keyBytes);
        }

        // Encrypt the file
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(keyBytes, "AES"));
        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile);
             CipherOutputStream cos = new CipherOutputStream(fos, cipher)) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                cos.write(buffer, 0, len);
            }
        }
    }

    public static void decryptFile(String inputFile, String outputFile) throws Exception {
        // Load the key
        byte[] keyBytes;
        try (FileInputStream fis = new FileInputStream("key.key")) {
            keyBytes = new byte[fis.available()];
            fis.read(keyBytes);
        }

        // Decrypt the file
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(keyBytes, "AES"));
        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile);
             CipherInputStream cis = new CipherInputStream(fis, cipher)) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = cis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        }
    }
}