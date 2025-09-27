package Vanilla.codestral;
import java.math.BigInteger;
import java.security.SecureRandom;

public class Task106 {
    private BigInteger p;
    private BigInteger q;
    private BigInteger n;
    private BigInteger phi;
    private BigInteger e;
    private BigInteger d;

    public Task106() {
        SecureRandom random = new SecureRandom();
        p = BigInteger.probablePrime(1024, random);
        q = BigInteger.probablePrime(1024, random);
        n = p.multiply(q);
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        e = BigInteger.probablePrime(1024 / 2, random);
        while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0) {
            e = e.add(BigInteger.ONE);
        }
        d = e.modInverse(phi);
    }

    public BigInteger encrypt(BigInteger message) {
        return message.modPow(e, n);
    }

    public BigInteger decrypt(BigInteger encryptedMessage) {
        return encryptedMessage.modPow(d, n);
    }

    public static void main(String[] args) {
        Task106 rsa = new Task106();
        BigInteger[] messages = {
            BigInteger.valueOf(12345),
            BigInteger.valueOf(67890),
            BigInteger.valueOf(54321),
            BigInteger.valueOf(98765),
            BigInteger.valueOf(13579)
        };

        for (BigInteger message : messages) {
            BigInteger encryptedMessage = rsa.encrypt(message);
            BigInteger decryptedMessage = rsa.decrypt(encryptedMessage);
            System.out.println("Original Message: " + message);
            System.out.println("Encrypted Message: " + encryptedMessage);
            System.out.println("Decrypted Message: " + decryptedMessage);
            System.out.println();
        }
    }
}