package ZeroShot.gemini;
import java.security.*;
import java.util.Base64;

public class Task134 {

    public static KeyPair generateKeyPair(String algorithm) throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance(algorithm);
        return keyGen.generateKeyPair();
    }


    public static String encrypt(String plaintext, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] ciphertext = cipher.doFinal(plaintext.getBytes());
        return Base64.getEncoder().encodeToString(ciphertext);
    }

    public static String decrypt(String ciphertext, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] plaintext = cipher.doFinal(Base64.getDecoder().decode(ciphertext));
        return new String(plaintext);
    }

    public static void main(String[] args) throws Exception {
        KeyPair keyPair = generateKeyPair("RSA");

        String plaintext1 = "Test message 1";
        String ciphertext1 = encrypt(plaintext1, keyPair.getPublic());
        String decrypted1 = decrypt(ciphertext1, keyPair.getPrivate());
        System.out.println("Plaintext: " + plaintext1 + ", Decrypted: " + decrypted1);


        String plaintext2 = "Test message 2 - slightly longer";
        String ciphertext2 = encrypt(plaintext2, keyPair.getPublic());
        String decrypted2 = decrypt(ciphertext2, keyPair.getPrivate());
        System.out.println("Plaintext: " + plaintext2 + ", Decrypted: " + decrypted2);

        String plaintext3 = "Short";
        String ciphertext3 = encrypt(plaintext3, keyPair.getPublic());
        String decrypted3 = decrypt(ciphertext3, keyPair.getPrivate());
        System.out.println("Plaintext: " + plaintext3 + ", Decrypted: " + decrypted3);

        String plaintext4 = "Special characters: !@#$%^&*()_+=-`~[]\';,./{}|:\"<>?";
        String ciphertext4 = encrypt(plaintext4, keyPair.getPublic());
        String decrypted4 = decrypt(ciphertext4, keyPair.getPrivate());
        System.out.println("Plaintext: " + plaintext4 + ", Decrypted: " + decrypted4);


        String plaintext5 = "Another test";
        String ciphertext5 = encrypt(plaintext5, keyPair.getPublic());
        String decrypted5 = decrypt(ciphertext5, keyPair.getPrivate());
        System.out.println("Plaintext: " + plaintext5 + ", Decrypted: " + decrypted5);
    }
}