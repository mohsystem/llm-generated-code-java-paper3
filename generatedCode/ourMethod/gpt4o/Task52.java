package ourMethod.gpt4o;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.security.SecureRandom;
import java.util.Arrays;

public class Task52 {
    
    private static final String ALGORITHM = "AES";
    private static final int KEY_SIZE = 128;
    
    public static byte[] generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
        keyGen.init(KEY_SIZE, new SecureRandom());
        SecretKey secretKey = keyGen.generateKey();
        return secretKey.getEncoded();
    }

    public static void encryptFile(File inputFile, File outputFile, byte[] key) throws Exception {
        doCrypto(Cipher.ENCRYPT_MODE, inputFile, outputFile, key);
    }

    public static void decryptFile(File inputFile, File outputFile, byte[] key) throws Exception {
        doCrypto(Cipher.DECRYPT_MODE, inputFile, outputFile, key);
    }

    private static void doCrypto(int cipherMode, File inputFile, File outputFile, byte[] key) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, ALGORITHM);
        cipher.init(cipherMode, secretKeySpec);

        try (FileInputStream inputStream = new FileInputStream(inputFile);
             FileOutputStream outputStream = new FileOutputStream(outputFile)) {

            byte[] inputBytes = new byte[(int) inputFile.length()];
            inputStream.read(inputBytes);

            byte[] outputBytes = cipher.doFinal(inputBytes);
            outputStream.write(outputBytes);
        }
    }

    public static void main(String[] args) throws Exception {
        byte[] key = generateKey();
        File inputFile = new File("testInput.txt");
        File encryptedFile = new File("testEncrypted.txt");
        File decryptedFile = new File("testDecrypted.txt");

        // Writing test data
        Files.write(inputFile.toPath(), "Test Data".getBytes());

        // Test Cases
        encryptFile(inputFile, encryptedFile, key);
        decryptFile(encryptedFile, decryptedFile, key);
        
        System.out.println("Encryption and Decryption completed.");
    }
}