package ourMethod.gemini;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Task52 {

    private static SecretKey key;

    public static void generateKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // Adjust key size as needed
        key = keyGen.generateKey();
    }


    public static void encryptFile(String inputFile, String outputFile) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException {
         Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile);
             CipherOutputStream cos = new CipherOutputStream(fos, cipher)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                cos.write(buffer, 0, bytesRead);
            }
        }
    }


    public static void decryptFile(String inputFile, String outputFile) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);

        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile);
             CipherInputStream cis = new CipherInputStream(fis, cipher)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = cis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }

    public static void main(String[] args) throws Exception {


        generateKey();
      
        encryptFile("test1.txt", "encrypted_test1.txt");
        decryptFile("encrypted_test1.txt", "decrypted_test1.txt");

        encryptFile("test2.txt", "encrypted_test2.txt");
        decryptFile("encrypted_test2.txt", "decrypted_test2.txt");

        encryptFile("test3.txt", "encrypted_test3.txt");
        decryptFile("encrypted_test3.txt", "decrypted_test3.txt");

        encryptFile("test4.txt", "encrypted_test4.txt");
        decryptFile("encrypted_test4.txt", "decrypted_test4.txt");

        encryptFile("test5.txt", "encrypted_test5.txt");
        decryptFile("encrypted_test5.txt", "decrypted_test5.txt");

        System.out.println("Files encrypted and decrypted successfully!");

    }
}