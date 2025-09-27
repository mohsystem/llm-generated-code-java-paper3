package ourMethod.claude;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.file.*;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

public class Task52 {
    private static final String ALGORITHM = "AES";
    private static final int KEY_SIZE = 256;
    
    // Generate random key
    private static byte[] generateKey() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] key = new byte[KEY_SIZE/8];
        secureRandom.nextBytes(key);
        return key;
    }

    // Encrypt file
    public static void encryptFile(String inputFile, String outputFile, byte[] key) throws Exception {
        if (key == null || key.length != KEY_SIZE/8) {
            throw new IllegalArgumentException("Invalid key");
        }

        SecretKey secretKey = new SecretKeySpec(key, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM + "/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile)) {
            
            byte[] inputBytes = Files.readAllBytes(Paths.get(inputFile));
            byte[] outputBytes = cipher.doFinal(inputBytes);
            fos.write(outputBytes);
        }
    }

    // Decrypt file  
    public static void decryptFile(String inputFile, String outputFile, byte[] key) throws Exception {
        if (key == null || key.length != KEY_SIZE/8) {
            throw new IllegalArgumentException("Invalid key");
        }

        SecretKey secretKey = new SecretKeySpec(key, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM + "/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile)) {
            
            byte[] inputBytes = Files.readAllBytes(Paths.get(inputFile));
            byte[] outputBytes = cipher.doFinal(inputBytes);
            fos.write(outputBytes);
        }
    }

    public static void main(String[] args) {
        try {
            // Test case 1: Small text file
            byte[] key1 = generateKey();
            encryptFile("test1.txt", "encrypted1.txt", key1);
            decryptFile("encrypted1.txt", "decrypted1.txt", key1);

            // Test case 2: Empty file
            byte[] key2 = generateKey();
            encryptFile("test2.txt", "encrypted2.txt", key2);
            decryptFile("encrypted2.txt", "decrypted2.txt", key2);

            // Test case 3: Binary file
            byte[] key3 = generateKey();
            encryptFile("test3.bin", "encrypted3.bin", key3);
            decryptFile("encrypted3.bin", "decrypted3.bin", key3);

            // Test case 4: Large text file
            byte[] key4 = generateKey();
            encryptFile("test4.txt", "encrypted4.txt", key4);
            decryptFile("encrypted4.txt", "decrypted4.txt", key4);

            // Test case 5: Invalid key test
            try {
                byte[] invalidKey = new byte[16]; // Wrong key size
                encryptFile("test5.txt", "encrypted5.txt", invalidKey);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid key detected successfully");
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
