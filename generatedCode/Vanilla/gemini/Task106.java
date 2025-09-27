package Vanilla.gemini;
import java.math.BigInteger;
import java.util.Random;

class Task106 {
    private BigInteger p, q, n, phi, e, d;

    public Task106(int bitLength) {
        Random rnd = new Random();
        p = BigInteger.probablePrime(bitLength / 2, rnd);
        q = BigInteger.probablePrime(bitLength / 2, rnd);
        n = p.multiply(q);
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        e = BigInteger.valueOf(65537);
        d = e.modInverse(phi);
    }

    public BigInteger encrypt(BigInteger message) {
        return message.modPow(e, n);
    }

    public BigInteger decrypt(BigInteger ciphertext) {
        return ciphertext.modPow(d, n);
    }

    public static void main(String[] args) {
        Task106 rsa = new Task106(1024);

        BigInteger[] messages = {
            BigInteger.valueOf(12345),
            BigInteger.valueOf(67890),
            BigInteger.valueOf(13579),
            BigInteger.valueOf(24680),
            new BigInteger("12345678901234567890")
        };

        for (BigInteger message : messages) {
            BigInteger ciphertext = rsa.encrypt(message);
            BigInteger decryptedMessage = rsa.decrypt(ciphertext);
            System.out.println("Message: " + message);
            System.out.println("Ciphertext: " + ciphertext);
            System.out.println("Decrypted: " + decryptedMessage);
            System.out.println("-----");
        }

    }
}