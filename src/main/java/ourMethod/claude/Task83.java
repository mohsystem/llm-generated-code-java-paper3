package ourMethod.claude;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;

public class Task83 {
    private static final String MAGIC = "ENC1";
    private static final int VERSION = 1;
    private static final int SALT_LENGTH = 16;
    private static final int IV_LENGTH = 12;
    private static final int TAG_LENGTH = 128;
    private static final int ITERATIONS = 210000;
    
    public static byte[] encryptData(String passphrase, byte[] dataToEncrypt) throws Exception {
        if (passphrase == null || passphrase.isEmpty()) {
            throw new IllegalArgumentException("Passphrase cannot be null or empty");
        }
        if (dataToEncrypt == null || dataToEncrypt.length == 0) {
            throw new IllegalArgumentException("Data to encrypt cannot be null or empty");
        }
        
        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        secureRandom.nextBytes(salt);
        
        byte[] iv = new byte[IV_LENGTH];
        secureRandom.nextBytes(iv);
        
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(passphrase.toCharArray(), salt, ITERATIONS, 256);
        SecretKey tmp = factory.generateSecret(spec);
        SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
        
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec gcmSpec = new GCMParameterSpec(TAG_LENGTH, iv);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, gcmSpec);
        
        byte[] ciphertextWithTag = cipher.doFinal(dataToEncrypt);
        
        ByteBuffer buffer = ByteBuffer.allocate(
            MAGIC.length() + 1 + SALT_LENGTH + IV_LENGTH + ciphertextWithTag.length
        );
        buffer.put(MAGIC.getBytes(StandardCharsets.UTF_8));
        buffer.put((byte) VERSION);
        buffer.put(salt);
        buffer.put(iv);
        buffer.put(ciphertextWithTag);
        
        return buffer.array();
    }
    
    public static byte[] decryptData(String passphrase, byte[] encryptedData) throws Exception {
        if (passphrase == null || passphrase.isEmpty()) {
            throw new IllegalArgumentException("Passphrase cannot be null or empty");
        }
        if (encryptedData == null || encryptedData.length < MAGIC.length() + 1 + SALT_LENGTH + IV_LENGTH + 16) {
            throw new IllegalArgumentException("Invalid encrypted data");
        }
        
        ByteBuffer buffer = ByteBuffer.wrap(encryptedData);
        
        byte[] magic = new byte[MAGIC.length()];
        buffer.get(magic);
        if (!Arrays.equals(magic, MAGIC.getBytes(StandardCharsets.UTF_8))) {
            throw new IllegalArgumentException("Invalid magic header");
        }
        
        byte version = buffer.get();
        if (version != VERSION) {
            throw new IllegalArgumentException("Unsupported version");
        }
        
        byte[] salt = new byte[SALT_LENGTH];
        buffer.get(salt);
        
        byte[] iv = new byte[IV_LENGTH];
        buffer.get(iv);
        
        byte[] ciphertextWithTag = new byte[buffer.remaining()];
        buffer.get(ciphertextWithTag);
        
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(passphrase.toCharArray(), salt, ITERATIONS, 256);
        SecretKey tmp = factory.generateSecret(spec);
        SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
        
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec gcmSpec = new GCMParameterSpec(TAG_LENGTH, iv);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, gcmSpec);
        
        return cipher.doFinal(ciphertextWithTag);
    }
    
    public static void main(String[] args) {
        try {
            System.out.println("Test Case 1: Basic encryption/decryption");
            String passphrase1 = "strongPassphrase123!";
            byte[] data1 = "Hello, World!".getBytes(StandardCharsets.UTF_8);
            byte[] encrypted1 = encryptData(passphrase1, data1);
            byte[] decrypted1 = decryptData(passphrase1, encrypted1);
            System.out.println("Original: " + new String(data1, StandardCharsets.UTF_8));
            System.out.println("Decrypted: " + new String(decrypted1, StandardCharsets.UTF_8));
            System.out.println("Match: " + Arrays.equals(data1, decrypted1));
            System.out.println();
            
            System.out.println("Test Case 2: Encrypt sensitive key data");
            String passphrase2 = "mySecureKey2023$";
            byte[] keyData = "API_KEY_12345_SECRET".getBytes(StandardCharsets.UTF_8);
            byte[] encrypted2 = encryptData(passphrase2, keyData);
            byte[] decrypted2 = decryptData(passphrase2, encrypted2);
            System.out.println("Key Match: " + Arrays.equals(keyData, decrypted2));
            System.out.println();
            
            System.out.println("Test Case 3: Different passphrase fails");
            String passphrase3a = "correctPassword";
            String passphrase3b = "wrongPassword";
            byte[] data3 = "Secret Message".getBytes(StandardCharsets.UTF_8);
            byte[] encrypted3 = encryptData(passphrase3a, data3);
            try {
                decryptData(passphrase3b, encrypted3);
                System.out.println("ERROR: Should have failed with wrong passphrase");
            } catch (Exception e) {
                System.out.println("Correctly rejected wrong passphrase");
            }
            System.out.println();
            
            System.out.println("Test Case 4: Encrypt binary data");
            String passphrase4 = "binaryDataKey!@#";
            byte[] binaryData = new byte[]{0x00, 0x01, 0x02, (byte) 0xFF, (byte) 0xFE};
            byte[] encrypted4 = encryptData(passphrase4, binaryData);
            byte[] decrypted4 = decryptData(passphrase4, encrypted4);
            System.out.println("Binary Match: " + Arrays.equals(binaryData, decrypted4));
            System.out.println();
            
            System.out.println("Test Case 5: Invalid input handling");
            try {
                encryptData(null, data1);
                System.out.println("ERROR: Should have rejected null passphrase");
            } catch (IllegalArgumentException e) {
                System.out.println("Correctly rejected null passphrase");
            }
            try {
                encryptData(passphrase1, null);
                System.out.println("ERROR: Should have rejected null data");
            } catch (IllegalArgumentException e) {
                System.out.println("Correctly rejected null data");
            }
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
