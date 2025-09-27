package ZeroShot.gemini;
import java.math.BigInteger;
import java.security.SecureRandom;

class Task106 {
    private BigInteger n, e, d;

    public Task106(int bitLength) {
        SecureRandom random = new SecureRandom();
        BigInteger p = BigInteger.probablePrime(bitLength / 2, random);
        BigInteger q = BigInteger.probablePrime(bitLength / 2, random);
        n = p.multiply(q);
        BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        e = new BigInteger("65537"); // Common public exponent
        while (phi.gcd(e).compareTo(BigInteger.ONE) != 0) {
            e = e.add(BigInteger.valueOf(2));
        }
        d = e.modInverse(phi);
    }

    public BigInteger encrypt(BigInteger message) {
        return message.modPow(e, n);
    }

    public BigInteger decrypt(BigInteger ciphertext) {
        return ciphertext.modPow(d, n);
    }


    public static void main(String[] args) {
        Task106 rsa = new Task106(1024); // Key size 1024 bits

        BigInteger message1 = new BigInteger("1234567890");
        BigInteger ciphertext1 = rsa.encrypt(message1);
        BigInteger decrypted1 = rsa.decrypt(ciphertext1);
        System.out.println("Test case 1:");
        System.out.println("Original message: " + message1);
        System.out.println("Encrypted: " + ciphertext1);
        System.out.println("Decrypted: " + decrypted1);


        BigInteger message2 = new BigInteger("9876543210");
        BigInteger ciphertext2 = rsa.encrypt(message2);
        BigInteger decrypted2 = rsa.decrypt(ciphertext2);
        System.out.println("\nTest case 2:");
        System.out.println("Original message: " + message2);
        System.out.println("Encrypted: " + ciphertext2);
        System.out.println("Decrypted: " + decrypted2);

        BigInteger message3 = new BigInteger("100");
        BigInteger ciphertext3 = rsa.encrypt(message3);
        BigInteger decrypted3 = rsa.decrypt(ciphertext3);
        System.out.println("\nTest case 3:");
        System.out.println("Original message: " + message3);
        System.out.println("Encrypted: " + ciphertext3);
        System.out.println("Decrypted: " + decrypted3);


        BigInteger message4 = new BigInteger("5555555");
        BigInteger ciphertext4 = rsa.encrypt(message4);
        BigInteger decrypted4 = rsa.decrypt(ciphertext4);
        System.out.println("\nTest case 4:");
        System.out.println("Original message: " + message4);
        System.out.println("Encrypted: " + ciphertext4);
        System.out.println("Decrypted: " + decrypted4);

        BigInteger message5 = new BigInteger("1212121212");
        BigInteger ciphertext5 = rsa.encrypt(message5);
        BigInteger decrypted5 = rsa.decrypt(ciphertext5);
        System.out.println("\nTest case 5:");
        System.out.println("Original message: " + message5);
        System.out.println("Encrypted: " + ciphertext5);
        System.out.println("Decrypted: " + decrypted5);

    }
}