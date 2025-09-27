package ourMethod.claude;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Arrays;

public class Task72 {
    private static final int BLOCK_SIZE = 16;
    private static final byte[] IV = generateStaticIV();
    
    private static byte[] generateStaticIV() {
        // Use SecureRandom for generating IV
        SecureRandom secureRandom = new SecureRandom();
        byte[] iv = new byte[BLOCK_SIZE];
        secureRandom.nextBytes(iv);
        return iv;
    }

    public static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        // Validate inputs
        if (data == null || key == null) {
            throw new IllegalArgumentException("Input data and key cannot be null");
        }
        if (key.length != 16 && key.length != 24 && key.length != 32) {
            throw new IllegalArgumentException("Key length must be 16, 24 or 32 bytes");
        }

        // Create cipher instance
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        
        // Create key and IV specs
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(IV);
        
        // Initialize cipher
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
        
        // Encrypt data
        return cipher.doFinal(data);
    }

    public static void main(String[] args) {
        try {
            // Test case 1: Basic encryption
            byte[] key1 = new byte[16];
            Arrays.fill(key1, (byte)1);
            byte[] data1 = "Hello World".getBytes();
            byte[] encrypted1 = encrypt(data1, key1);
            System.out.println("Test 1: " + Arrays.toString(encrypted1));

            // Test case 2: Empty string
            byte[] data2 = "".getBytes();
            byte[] encrypted2 = encrypt(data2, key1);
            System.out.println("Test 2: " + Arrays.toString(encrypted2));

            // Test case 3: Long string
            byte[] data3 = "This is a much longer string that will require multiple blocks".getBytes();
            byte[] encrypted3 = encrypt(data3, key1);
            System.out.println("Test 3: " + Arrays.toString(encrypted3));

            // Test case 4: Binary data
            byte[] data4 = {1, 2, 3, 4, 5};
            byte[] encrypted4 = encrypt(data4, key1);
            System.out.println("Test 4: " + Arrays.toString(encrypted4));

            // Test case 5: Different key size
            byte[] key5 = new byte[32];
            Arrays.fill(key5, (byte)2);
            byte[] data5 = "Testing with 256-bit key".getBytes();
            byte[] encrypted5 = encrypt(data5, key5);
            System.out.println("Test 5: " + Arrays.toString(encrypted5));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
