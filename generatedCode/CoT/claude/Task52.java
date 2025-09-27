package CoT.claude;

import java.io.*;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.file.*;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

public class Task52 {
    private static final String ALGORITHM = "AES";
    private static SecretKey secretKey;
    
    private static void generateKey(String myKey) throws Exception {
        MessageDigest sha = MessageDigest.getInstance("SHA-1");
        byte[] key = myKey.getBytes("UTF-8");
        key = sha.digest(key);
        key = Arrays.copyOf(key, 16);
        secretKey = new SecretKeySpec(key, ALGORITHM);
    }

    public static byte[] encrypt(byte[] data, String password) throws Exception {
        generateKey(password);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(data);
    }
    
    public static byte[] decrypt(byte[] encrypted, String password) throws Exception {
        generateKey(password);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return cipher.doFinal(encrypted);
    }

    public static void encryptFile(String inputFile, String outputFile, String password) throws Exception {
        byte[] fileContent = Files.readAllBytes(Paths.get(inputFile));
        byte[] encrypted = encrypt(fileContent, password);
        Files.write(Paths.get(outputFile), encrypted);
    }

    public static void decryptFile(String inputFile, String outputFile, String password) throws Exception {
        byte[] fileContent = Files.readAllBytes(Paths.get(inputFile));
        byte[] decrypted = decrypt(fileContent, password);
        Files.write(Paths.get(outputFile), decrypted);
    }

    public static void main(String[] args) {
        try {
            // Test case 1: Encrypt and decrypt a text file
            String content1 = "Hello World!";
            Files.write(Paths.get("test1.txt"), content1.getBytes());
            encryptFile("test1.txt", "encrypted1.txt", "password123");
            decryptFile("encrypted1.txt", "decrypted1.txt", "password123");
            
            // Test case 2: Encrypt and decrypt with special characters
            String content2 = "Hello @#$%^&*()";
            Files.write(Paths.get("test2.txt"), content2.getBytes());
            encryptFile("test2.txt", "encrypted2.txt", "pass@123");
            decryptFile("encrypted2.txt", "decrypted2.txt", "pass@123");
            
            // Test case 3: Encrypt and decrypt empty file
            Files.write(Paths.get("test3.txt"), "".getBytes());
            encryptFile("test3.txt", "encrypted3.txt", "password");
            decryptFile("encrypted3.txt", "decrypted3.txt", "password");
            
            // Test case 4: Encrypt and decrypt large content
            StringBuilder content4 = new StringBuilder();
            for(int i = 0; i < 1000; i++) content4.append("test");
            Files.write(Paths.get("test4.txt"), content4.toString().getBytes());
            encryptFile("test4.txt", "encrypted4.txt", "longpassword");
            decryptFile("encrypted4.txt", "decrypted4.txt", "longpassword");
            
            // Test case 5: Encrypt and decrypt with long password
            String content5 = "Test with long password";
            Files.write(Paths.get("test5.txt"), content5.getBytes());
            encryptFile("test5.txt", "encrypted5.txt", "verylongpasswordforencryption");
            decryptFile("encrypted5.txt", "decrypted5.txt", "verylongpasswordforencryption");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
