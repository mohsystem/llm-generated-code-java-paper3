package ourMethod.claude;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Task106 {
    private BigInteger n, d, e; // n is modulus, d is private key, e is public key
    private final int KEY_SIZE = 2048; // Using 2048 bits for strong security
    private final SecureRandom random;

    public Task106() {
        random = new SecureRandom();
    }

    public void generateKeys() {
        // Generate two large prime numbers
        BigInteger p = BigInteger.probablePrime(KEY_SIZE/2, random);
        BigInteger q = BigInteger.probablePrime(KEY_SIZE/2, random);
        
        // Calculate n = p * q
        n = p.multiply(q);
        
        // Calculate phi = (p-1)(q-1)
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        
        // Choose e coprime to phi
        e = BigInteger.valueOf(65537); // Commonly used value for e
        
        // Calculate d (multiplicative inverse of e modulo phi)
        d = e.modInverse(phi);
    }

    public BigInteger encrypt(BigInteger message) {
        if (message.compareTo(n) >= 0) {
            throw new IllegalArgumentException("Message too large");
        }
        return message.modPow(e, n);
    }

    public BigInteger decrypt(BigInteger encryptedMessage) {
        return encryptedMessage.modPow(d, n);
    }

    public static void main(String[] args) {
        Task106 rsa = new Task106();
        rsa.generateKeys();

        // Test cases
        BigInteger[] testMessages = {
            new BigInteger("123456789"),
            new BigInteger("987654321"),
            new BigInteger("112233445566"),
            new BigInteger("998877665544"),
            new BigInteger("123123123123")
        };

        for (BigInteger msg : testMessages) {
            try {
                System.out.println("Original: " + msg);
                BigInteger encrypted = rsa.encrypt(msg);
                System.out.println("Encrypted: " + encrypted);
                BigInteger decrypted = rsa.decrypt(encrypted);
                System.out.println("Decrypted: " + decrypted);
                System.out.println("Successful: " + msg.equals(decrypted));
                System.out.println();
            } catch (Exception e) {
                System.err.println("Error processing message: " + msg);
                e.printStackTrace();
            }
        }
    }
}
