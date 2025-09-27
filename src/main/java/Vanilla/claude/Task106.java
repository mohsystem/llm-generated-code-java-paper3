package Vanilla.claude;

import java.math.BigInteger;
import java.util.Random;

public class Task106 {
    private BigInteger n, d, e;
    
    public Task106() {
        generateKeys(512);
    }
    
    public void generateKeys(int bits) {
        Random r = new Random();
        BigInteger p = BigInteger.probablePrime(bits, r);
        BigInteger q = BigInteger.probablePrime(bits, r);
        n = p.multiply(q);
        BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        e = BigInteger.probablePrime(bits/2, r);
        while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0) {
            e = e.add(BigInteger.ONE);
        }
        d = e.modInverse(phi);
    }
    
    public BigInteger encrypt(BigInteger message) {
        return message.modPow(e, n);
    }
    
    public BigInteger decrypt(BigInteger encrypted) {
        return encrypted.modPow(d, n);
    }
    
    public static void main(String[] args) {
        Task106 rsa = new Task106();
        
        // Test case 1
        BigInteger msg1 = new BigInteger("123");
        BigInteger encrypted1 = rsa.encrypt(msg1);
        System.out.println("Test 1: " + msg1.equals(rsa.decrypt(encrypted1)));
        
        // Test case 2
        BigInteger msg2 = new BigInteger("456789");
        BigInteger encrypted2 = rsa.encrypt(msg2);
        System.out.println("Test 2: " + msg2.equals(rsa.decrypt(encrypted2)));
        
        // Test case 3
        BigInteger msg3 = new BigInteger("1000000");
        BigInteger encrypted3 = rsa.encrypt(msg3);
        System.out.println("Test 3: " + msg3.equals(rsa.decrypt(encrypted3)));
        
        // Test case 4
        BigInteger msg4 = new BigInteger("987654321");
        BigInteger encrypted4 = rsa.encrypt(msg4);
        System.out.println("Test 4: " + msg4.equals(rsa.decrypt(encrypted4)));
        
        // Test case 5
        BigInteger msg5 = new BigInteger("555555555");
        BigInteger encrypted5 = rsa.encrypt(msg5);
        System.out.println("Test 5: " + msg5.equals(rsa.decrypt(encrypted5)));
    }
}
