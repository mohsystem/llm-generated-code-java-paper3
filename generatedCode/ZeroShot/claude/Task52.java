package ZeroShot.claude;

import java.io.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Task52 {
    private static final String ALGORITHM = "AES";
    private static final String KEY = "ThisIsA128BitKey";
    
    public static String encrypt(String data) throws Exception {
        SecretKeySpec key = new SecretKeySpec(KEY.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
    
    public static String decrypt(String encryptedData) throws Exception {
        SecretKeySpec key = new SecretKeySpec(KEY.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decryptedBytes);
    }

    public static void main(String[] args) {
        try {
            // Test case 1
            String text1 = "Hello World";
            String encrypted1 = encrypt(text1);
            System.out.println("Test 1 - Original: " + text1);
            System.out.println("Encrypted: " + encrypted1);
            System.out.println("Decrypted: " + decrypt(encrypted1));

            // Test case 2
            String text2 = "Sensitive Data 123";
            String encrypted2 = encrypt(text2);
            System.out.println("\\nTest 2 - Original: " + text2);
            System.out.println("Encrypted: " + encrypted2);
            System.out.println("Decrypted: " + decrypt(encrypted2));

            // Test case 3
            String text3 = "!@#$%^&*()";
            String encrypted3 = encrypt(text3);
            System.out.println("\\nTest 3 - Original: " + text3);
            System.out.println("Encrypted: " + encrypted3);
            System.out.println("Decrypted: " + decrypt(encrypted3));

            // Test case 4
            String text4 = "Lorem ipsum dolor sit amet";
            String encrypted4 = encrypt(text4);
            System.out.println("\\nTest 4 - Original: " + text4);
            System.out.println("Encrypted: " + encrypted4);
            System.out.println("Decrypted: " + decrypt(encrypted4));

            // Test case 5
            String text5 = "12345678901234567890";
            String encrypted5 = encrypt(text5);
            System.out.println("\\nTest 5 - Original: " + text5);
            System.out.println("Encrypted: " + encrypted5);
            System.out.println("Decrypted: " + decrypt(encrypted5));

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
