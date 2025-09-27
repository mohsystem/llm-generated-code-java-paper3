package ZeroShot.gemini;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

class Task52 {

    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";

    public static void encrypt(String key, String inputFile, String outputFile)
            throws CryptoException {
        doCrypto(Cipher.ENCRYPT_MODE, key, inputFile, outputFile);
    }

    public static void decrypt(String key, String inputFile, String outputFile)
            throws CryptoException {
        doCrypto(Cipher.DECRYPT_MODE, key, inputFile, outputFile);
    }

    private static void doCrypto(int cipherMode, String key, String inputFile, String outputFile)
            throws CryptoException {
        try {
            Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(cipherMode, secretKey);

            FileInputStream inputStream = new FileInputStream(inputFile);
            byte[] inputBytes = new byte[(int) inputFile.length()];
            inputStream.read(inputBytes);

            byte[] outputBytes = cipher.doFinal(inputBytes);

            FileOutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write(outputBytes);

            inputStream.close();
            outputStream.close();

        } catch (NoSuchPaddingException | NoSuchAlgorithmException
                | InvalidKeyException | IOException ex) {
            throw new CryptoException("Error encrypting/decrypting file", ex);
        }
    }


    public static void main(String[] args) {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128); // for example
            Key key = keyGen.generateKey();

            String keyString = new String(key.getEncoded()); // Store this securely

          encrypt(keyString,"test1.txt","test1.enc");
          decrypt(keyString, "test1.enc", "test1.dec");

          encrypt(keyString,"test2.txt","test2.enc");
          decrypt(keyString, "test2.enc", "test2.dec");

          encrypt(keyString,"test3.txt","test3.enc");
          decrypt(keyString, "test3.enc", "test3.dec");

          encrypt(keyString,"test4.txt","test4.enc");
          decrypt(keyString, "test4.enc", "test4.dec");

          encrypt(keyString,"test5.txt","test5.enc");
          decrypt(keyString, "test5.enc", "test5.dec");



        } catch (Exception e) {
             System.out.println(e.getMessage());
        }
    }


    public static class CryptoException extends Exception {
        public CryptoException(String message, Throwable throwable) {
            super(message, throwable);
        }
    }
}