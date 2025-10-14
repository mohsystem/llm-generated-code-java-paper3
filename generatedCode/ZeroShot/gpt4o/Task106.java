package ZeroShot.openai;
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
        e = new BigInteger("65537");
        d = e.modInverse(m);
    }

    public Task106(BigInteger e, BigInteger d, BigInteger n) {
        this.e = e;
        this.d = d;
        this.n = n;
    }

    public synchronized byte[] encrypt(byte[] message) {
        return (new BigInteger(message)).modPow(e, n).toByteArray();
    }

    public synchronized byte[] decrypt(byte[] encrypted) {
        return (new BigInteger(encrypted)).modPow(d, n).toByteArray();
    }

    public static void main(String[] args) {
        Task106 rsa = new Task106();
        String text1 = "Hello World!";
        String text2 = "Secure RSA";
        String text3 = "Encryption Test";
        String text4 = "Java RSA";
        String text5 = "Decrypt Test";
        
        byte[] encrypted1 = rsa.encrypt(text1.getBytes());
        byte[] encrypted2 = rsa.encrypt(text2.getBytes());
        byte[] encrypted3 = rsa.encrypt(text3.getBytes());
        byte[] encrypted4 = rsa.encrypt(text4.getBytes());
        byte[] encrypted5 = rsa.encrypt(text5.getBytes());

        System.out.println(new String(rsa.decrypt(encrypted1)));
        System.out.println(new String(rsa.decrypt(encrypted2)));
        System.out.println(new String(rsa.decrypt(encrypted3)));
        System.out.println(new String(rsa.decrypt(encrypted4)));
        System.out.println(new String(rsa.decrypt(encrypted5)));
    }
}