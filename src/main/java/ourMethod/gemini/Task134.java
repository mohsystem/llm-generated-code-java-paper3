package ourMethod.gemini;
import java.security.*;
import java.security.spec.*;
import java.util.Base64;
import javax.crypto.*;
import javax.crypto.spec.*;

public class Task134 {

    public static KeyPair generateKeyPair(String algorithm, int keySize) throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance(algorithm);
        keyGen.initialize(keySize);
        return keyGen.generateKeyPair();
    }


    public static String encrypt(String algorithm, String plainText, Key key) throws NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] cipherText = cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(cipherText);
    }

    public static String decrypt(String algorithm, String cipherText, Key key) throws NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] plainText = cipher.doFinal(Base64.getDecoder().decode(cipherText));
        return new String(plainText);
    }


    public static void main(String[] args) throws Exception {

        // Test cases
        KeyPair rsaKeyPair = generateKeyPair("RSA", 2048);

        String plainText1 = "Test Case 1";
        String cipherText1 = encrypt("RSA", plainText1, rsaKeyPair.getPublic());
        String decryptedText1 = decrypt("RSA", cipherText1, rsaKeyPair.getPrivate());
        System.out.println("Test 1 - Original: " + plainText1 + ", Decrypted: " + decryptedText1);


        KeyPair aesKeyPair = generateKeyPair("AES", 128);
        String plainText2 = "Test Case 2";
        String cipherText2 = encrypt("AES", plainText2, aesKeyPair.getPublic());
        String decryptedText2 = decrypt("AES", cipherText2, aesKeyPair.getPrivate());
        System.out.println("Test 2 - Original: " + plainText2 + ", Decrypted: " + decryptedText2);


        String plainText3 = "Test Case 3 - Longer Text";
        String cipherText3 = encrypt("RSA", plainText3, rsaKeyPair.getPublic());
        String decryptedText3 = decrypt("RSA", cipherText3, rsaKeyPair.getPrivate());
        System.out.println("Test 3 - Original: " + plainText3 + ", Decrypted: " + decryptedText3);

        String plainText4 = "Test Case 4 - Special Characters: !@#$%^&*()_+=-`~[]\';,./{}|:\"<>?";
        String cipherText4 = encrypt("RSA", plainText4, rsaKeyPair.getPublic());
        String decryptedText4 = decrypt("RSA", cipherText4, rsaKeyPair.getPrivate());
        System.out.println("Test 4 - Original: " + plainText4 + ", Decrypted: " + decryptedText4);


        String plainText5 = "Test Case 5 - Unicode characters:  你好世界";
        String cipherText5 = encrypt("RSA", plainText5, rsaKeyPair.getPublic());
        String decryptedText5 = decrypt("RSA", cipherText5, rsaKeyPair.getPrivate());
        System.out.println("Test 5 - Original: " + plainText5 + ", Decrypted: " + decryptedText5);

    }
}