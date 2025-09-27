package CoT.gemini;
import java.math.BigInteger;
import java.security.SecureRandom;

public class Task106 {

    public static BigInteger[] generateKeyPair(int bitLength) {
        SecureRandom random = new SecureRandom();
        BigInteger p = BigInteger.probablePrime(bitLength / 2, random);
        BigInteger q = BigInteger.probablePrime(bitLength / 2, random);
        BigInteger n = p.multiply(q);
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        BigInteger e = BigInteger.valueOf(65537); // Common public exponent
        while (e.gcd(phi).compareTo(BigInteger.ONE) != 0) {
            e = e.add(BigInteger.TWO);
        }
        BigInteger d = e.modInverse(phi);
        return new BigInteger[]{n, e, d};
    }


    public static BigInteger encrypt(BigInteger message, BigInteger n, BigInteger e) {
        return message.modPow(e, n);
    }

    public static BigInteger decrypt(BigInteger ciphertext, BigInteger n, BigInteger d) {
        return ciphertext.modPow(d, n);
    }

    public static void main(String[] args) {
        BigInteger[] keyPair = generateKeyPair(1024);
        BigInteger n = keyPair[0];
        BigInteger e = keyPair[1];
        BigInteger d = keyPair[2];

        String message1 = "Test message 1";
        BigInteger message1BigInt = new BigInteger(message1.getBytes());
        BigInteger ciphertext1 = encrypt(message1BigInt, n, e);
        BigInteger decrypted1 = decrypt(ciphertext1, n, d);
        System.out.println("Original message 1: " + message1);
        System.out.println("Decrypted message 1: " + new String(decrypted1.toByteArray()));

        String message2 = "Test message 2 - slightly longer";
        BigInteger message2BigInt = new BigInteger(message2.getBytes());
        BigInteger ciphertext2 = encrypt(message2BigInt, n, e);
        BigInteger decrypted2 = decrypt(ciphertext2, n, d);
        System.out.println("Original message 2: " + message2);
        System.out.println("Decrypted message 2: " + new String(decrypted2.toByteArray()));

        String message3 = "Short";
        BigInteger message3BigInt = new BigInteger(message3.getBytes());
        BigInteger ciphertext3 = encrypt(message3BigInt, n, e);
        BigInteger decrypted3 = decrypt(ciphertext3, n, d);
        System.out.println("Original message 3: " + message3);
        System.out.println("Decrypted message 3: " + new String(decrypted3.toByteArray()));

        String message4 = "Special characters: !@#$%^&*()_+=-`~\\|<>,.?/:;'\"]";
        BigInteger message4BigInt = new BigInteger(message4.getBytes());
        BigInteger ciphertext4 = encrypt(message4BigInt, n, e);
        BigInteger decrypted4 = decrypt(ciphertext4, n, d);
        System.out.println("Original message 4: " + message4);
        System.out.println("Decrypted message 4: " + new String(decrypted4.toByteArray()));

        String message5 = "Another test";
        BigInteger message5BigInt = new BigInteger(message5.getBytes());
        BigInteger ciphertext5 = encrypt(message5BigInt, n, e);
        BigInteger decrypted5 = decrypt(ciphertext5, n, d);
        System.out.println("Original message 5: " + message5);
        System.out.println("Decrypted message 5: " + new String(decrypted5.toByteArray()));

    }
}