package CoT.gemini;
import java.security.*;
import javax.crypto.*;
import java.util.Base64;

public class Task134 {

    public static String generateKey(String algorithm) throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance(algorithm);
        SecretKey key = keyGen.generateKey();
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }


    public static String encrypt(String algorithm, String key, String plaintext) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.getDecoder().decode(key), algorithm);
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);

    }

    public static String decrypt(String algorithm, String key, String ciphertext) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.getDecoder().decode(key), algorithm);
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(ciphertext));
        return new String(decryptedBytes);
    }



    public static void main(String[] args) throws Exception {
        // Test cases
        String key1 = generateKey("AES");
        String encrypted1 = encrypt("AES", key1, "Test 1");
        String decrypted1 = decrypt("AES", key1, encrypted1);
        System.out.println("Test 1: " + decrypted1);


        String key2 = generateKey("DES");
        String encrypted2 = encrypt("DES", key2, "Test 2");
        String decrypted2 = decrypt("DES", key2, encrypted2);
        System.out.println("Test 2: " + decrypted2);


        String key3 = generateKey("Blowfish");
        String encrypted3 = encrypt("Blowfish", key3,"Test 3");
        String decrypted3 = decrypt("Blowfish", key3, encrypted3);
        System.out.println("Test 3: " + decrypted3);


        String key4 = generateKey("AES");
        String encrypted4 = encrypt("AES", key4, "Test 4");
        String decrypted4 = decrypt("AES", key4, encrypted4);
        System.out.println("Test 4: " + decrypted4);


        String key5 = generateKey("DES");
        String encrypted5 = encrypt("DES", key5,  "Test 5");
        String decrypted5 = decrypt("DES", key5, encrypted5);
        System.out.println("Test 5: " + decrypted5);

    }
}