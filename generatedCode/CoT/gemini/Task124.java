package CoT.gemini;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class Task124 {

    private static final String ALGORITHM = "AES/GCM/NoPadding"; // Secure, modern cipher
    private static final int KEY_LENGTH = 256; // Strong key length
    private static final int SALT_LENGTH = 16; // Secure salt length
    private static final int ITERATIONS = 65536; // High iteration count for key derivation

    private static Map<String, String> encryptedData = new HashMap<>();

    public static String encrypt(String data, String password) throws Exception {
        // Generate a secure random salt
        SecureRandom random = SecureRandom.getInstanceStrong();
        byte[] salt = new byte[SALT_LENGTH];
        random.nextBytes(salt);

        // Derive a secure encryption key from the password and salt
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, KEY_LENGTH);
        SecretKey tmp = factory.generateSecret(spec);
        SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

        // Encrypt the data using AES-GCM
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());

        // Encode the salt and encrypted data as a Base64 string
        String saltBase64 = Base64.getEncoder().encodeToString(salt);
        String encryptedDataBase64 = Base64.getEncoder().encodeToString(encryptedBytes);
        return saltBase64 + ":" + encryptedDataBase64;
    }

    public static String decrypt(String encryptedData, String password) throws Exception {
        // Split the encrypted data into salt and ciphertext
        String[] parts = encryptedData.split(":");
        byte[] salt = Base64.getDecoder().decode(parts[0]);
        byte[] encryptedBytes = Base64.getDecoder().decode(parts[1]);

        // Derive the encryption key
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, KEY_LENGTH);
        SecretKey tmp = factory.generateSecret(spec);
        SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

        // Decrypt the data
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes);
    }

    public static void storeData(String key, String data, String password) throws Exception {
        String encryptedValue = encrypt(data, password);
        encryptedData.put(key, encryptedValue);
    }

    public static String retrieveData(String key, String password) throws Exception {
        String encryptedValue = encryptedData.get(key);
        if (encryptedValue == null) {
            return null;
        }
        return decrypt(encryptedValue, password);
    }


    public static void main(String[] args) throws Exception {
        String masterPassword = "testpassword"; // In real app, get password securely
        storeData("creditCard", "1234-5678-9012-3456", masterPassword);
        storeData("ssn", "123-45-6789", masterPassword);
        System.out.println("Credit Card: " + retrieveData("creditCard", masterPassword));
        System.out.println("SSN: " + retrieveData("ssn", masterPassword));


        storeData("test1", "test value 1", masterPassword);
        String retrieved1 = retrieveData("test1", masterPassword);
        System.out.println("test1: " + retrieved1);

        storeData("test2", "another test value", masterPassword);
        System.out.println("test2: " + retrieveData("test2", masterPassword));

        storeData("test3", "1234567890", masterPassword);
        System.out.println("test3: " + retrieveData("test3", masterPassword));

        storeData("test4", "special characters !@#$%^&*()", masterPassword);
        System.out.println("test4: " + retrieveData("test4", masterPassword));

        storeData("test5", "   leading and trailing spaces   ", masterPassword);
        System.out.println("test5: " + retrieveData("test5", masterPassword));
    }
}