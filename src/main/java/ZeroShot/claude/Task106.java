package ZeroShot.claude;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Task106 {
    private BigInteger n, d, e;
    
    public Task106() {
        generateKeys(1024);
    }
    
    public void generateKeys(int bitLength) {
        SecureRandom r = new SecureRandom();
        BigInteger p = BigInteger.probablePrime(bitLength/2, r);
        BigInteger q = BigInteger.probablePrime(bitLength/2, r);
        n = p.multiply(q);
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        e = BigInteger.valueOf(65537);
        d = e.modInverse(phi);
    }
    
    public byte[] encrypt(byte[] message) {
        return new BigInteger(message).modPow(e, n).toByteArray();
    }
    
    public byte[] decrypt(byte[] message) {
        return new BigInteger(message).modPow(d, n).toByteArray();
    }
    
    public static void main(String[] args) {
        Task106 rsa = new Task106();
        
        // Test case 1
        String msg1 = "Hello World";
        byte[] encrypted1 = rsa.encrypt(msg1.getBytes());
        byte[] decrypted1 = rsa.decrypt(encrypted1);
        System.out.println("Test 1: " + new String(decrypted1));
        
        // Test case 2
        String msg2 = "RSA Encryption";
        byte[] encrypted2 = rsa.encrypt(msg2.getBytes());
        byte[] decrypted2 = rsa.decrypt(encrypted2);
        System.out.println("Test 2: " + new String(decrypted2));
        
        // Test case 3
        String msg3 = "Cryptography";
        byte[] encrypted3 = rsa.encrypt(msg3.getBytes());
        byte[] decrypted3 = rsa.decrypt(encrypted3);
        System.out.println("Test 3: " + new String(decrypted3));
        
        // Test case 4
        String msg4 = "Security";
        byte[] encrypted4 = rsa.encrypt(msg4.getBytes());
        byte[] decrypted4 = rsa.decrypt(encrypted4);
        System.out.println("Test 4: " + new String(decrypted4));
        
        // Test case 5
        String msg5 = "Test Message";
        byte[] encrypted5 = rsa.encrypt(msg5.getBytes());
        byte[] decrypted5 = rsa.decrypt(encrypted5);
        System.out.println("Test 5: " + new String(decrypted5));
    }
}
