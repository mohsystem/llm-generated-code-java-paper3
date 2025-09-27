package CoT.gpt4o;
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

    public Task106(BigInteger e, BigInteger d, BigInteger n) {
        this.e = e;
        this.d = d;
        this.n = n;
    }

    public synchronized String encrypt(String message) {
        return (new BigInteger(message.getBytes())).modPow(e, n).toString();
    }

    public synchronized String decrypt(String message) {
        return new String((new BigInteger(message)).modPow(d, n).toByteArray());
    }

    public static void main(String[] args) {
        Task106 rsa = new Task106();

        String[] testMessages = {
            "Test message 1",
            "Test message 2",
            "Test message 3",
            "Test message 4",
            "Test message 5"
        };

        for (String message : testMessages) {
            String encrypted = rsa.encrypt(message);
            String decrypted = rsa.decrypt(encrypted);
            System.out.println("Original: " + message);
            System.out.println("Encrypted: " + encrypted);
            System.out.println("Decrypted: " + decrypted);
            System.out.println();
        }
    }
}