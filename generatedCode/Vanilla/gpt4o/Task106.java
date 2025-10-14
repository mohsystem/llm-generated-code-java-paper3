package Vanilla.openai;
import java.math.BigInteger;
import java.security.SecureRandom;

public class Task106 {
    private BigInteger n, d, e;
    private int bitlen = 1024;

    public Task106() {
        SecureRandom r = new SecureRandom();
        BigInteger p = new BigInteger(bitlen / 2, 100, r);
        BigInteger q = new BigInteger(bitlen / 2, 100, r);
        n = p.multiply(q);
        BigInteger m = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        e = new BigInteger("3");
        while (m.gcd(e).intValue() > 1) {
            e = e.add(new BigInteger("2"));
        }
        d = e.modInverse(m);
    }

    public BigInteger encrypt(BigInteger message) {
        return message.modPow(e, n);
    }

    public BigInteger decrypt(BigInteger encrypted) {
        return encrypted.modPow(d, n);
    }

    public static void main(String[] args) {
        Task106 rsa = new Task106();
        String[] messages = {"123", "456", "789", "101112", "131415"};
        for (String message : messages) {
            BigInteger plaintext = new BigInteger(message);
            BigInteger ciphertext = rsa.encrypt(plaintext);
            BigInteger decrypted = rsa.decrypt(ciphertext);
            System.out.println("Message: " + message);
            System.out.println("Encrypted: " + ciphertext);
            System.out.println("Decrypted: " + decrypted);
            System.out.println();
        }
    }
}