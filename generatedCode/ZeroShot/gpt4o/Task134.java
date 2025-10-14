package ZeroShot.openai;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

public class Task134 {
    public static SecretKey generateKey(int keySize) throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(keySize);
        return keyGen.generateKey();
    }

    public static void main(String[] args) {
        try {
            SecretKey key1 = generateKey(128);
            SecretKey key2 = generateKey(192);
            SecretKey key3 = generateKey(256);
            SecretKey key4 = generateKey(128);
            SecretKey key5 = generateKey(192);
            System.out.println("Keys generated successfully.");
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error generating keys: " + e.getMessage());
        }
    }
}