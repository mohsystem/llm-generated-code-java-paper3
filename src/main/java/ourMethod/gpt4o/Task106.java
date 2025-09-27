package ourMethod.gpt4o;
import java.math.BigInteger;
import java.security.SecureRandom;

public class Task106 {

    private BigInteger n, d, e;
    private int bitlen = 1024;

    public Task106() {
        SecureRandom r = new SecureRandom();
        BigInteger p = BigInteger.probablePrime(bitlen / 2, r);
        BigInteger q = BigInteger.probablePrime(bitlen / 2, r);
        n = p.multiply(q);
        BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        e = BigInteger.probablePrime(bitlen / 2, r);

        while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0) {
            e.add(BigInteger.ONE);
        }
        d = e.modInverse(phi);
    }

    public Task106(BigInteger e, BigInteger d, BigInteger n) {
        this.e = e;
        this.d = d;
        this.n = n;
    }

    public synchronized String encrypt(String message) {
        return new BigInteger(message.getBytes()).modPow(e, n).toString();
    }

    public synchronized String decrypt(String message) {
        return new String(new BigInteger(message).modPow(d, n).toByteArray());
    }

    public static void main(String[] args) {
        Task106 rsa = new Task106();
        String testMessages[] = {"Hello", "World", "RSA", "Encryption", "Test"};
        
        for(String message : testMessages) {
            String encrypted = rsa.encrypt(message);
            String decrypted = rsa.decrypt(encrypted);
            System.out.println("Message: " + message);
            System.out.println("Encrypted: " + encrypted);
            System.out.println("Decrypted: " + decrypted);
        }
    }
}