package ourMethod.gemini;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

class Task106 {

    public static String encrypt(String message, BigInteger e, BigInteger n) {
        byte[] bytes = message.getBytes();
        BigInteger m = new BigInteger(bytes);
        BigInteger c = m.modPow(e, n);
        return c.toString(16);
    }

    public static String decrypt(String ciphertext, BigInteger d, BigInteger n) {
        BigInteger c = new BigInteger(ciphertext, 16);
        BigInteger m = c.modPow(d, n);
        byte[] bytes = m.toByteArray();
        return new String(bytes);
    }
    
    public static BigInteger[] generateKeypair(int bitLength) {
        SecureRandom random = new SecureRandom();
        BigInteger p = new BigInteger(bitLength / 2, 100, random);
        BigInteger q = new BigInteger(bitLength / 2, 100, random);
        BigInteger n = p.multiply(q);
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        BigInteger e = new BigInteger("65537");
        BigInteger d = e.modInverse(phi);
        return new BigInteger[]{n, e, d};
    }

    public static void main(String[] args) {
        int bitLength = 2048;
        BigInteger[] keypair = generateKeypair(bitLength);
        BigInteger n = keypair[0];
        BigInteger e = keypair[1];
        BigInteger d = keypair[2];

        String[] messages = {
            "Hello, world!",
            "This is a test message.",
            "RSA encryption and decryption.",
            "Another test message for RSA.",
            "The quick brown fox jumps over the lazy dog."
        };

        for (String message : messages) {
            String ciphertext = encrypt(message, e, n);
            String decryptedMessage = decrypt(ciphertext, d, n);
            System.out.println("Original message: " + message);
            System.out.println("Ciphertext: " + ciphertext);
            System.out.println("Decrypted message: " + decryptedMessage);
            System.out.println("--------------------");

        }

    }
}