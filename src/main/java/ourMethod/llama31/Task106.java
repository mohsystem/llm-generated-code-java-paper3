package ourMethod.llama31;
public class Task106 {
    public static void main(String[] args) {
        int p = 61; // First prime number
        int q = 53; // Second prime number
        int n = p * q; // Modulus
        int phi = (p - 1) * (q - 1); // Euler's totient function
        int e = 17; // Public exponent
        int d = modInverse(e, phi); // Private exponent

        System.out.println("Public Key: (" + e + ", " + n + ")");
        System.out.println("Private Key: (" + d + ", " + n + ")");

        // Test cases
        int[] messages = {12, 24, 36, 48, 60};
        for (int message : messages) {
            int encrypted = encrypt(message, e, n);
            int decrypted = decrypt(encrypted, d, n);
            System.out.println("Message: " + message + ", Encrypted: " + encrypted + ", Decrypted: " + decrypted);
        }
    }

    public static int encrypt(int message, int e, int n) {
        return modPow(message, e, n);
    }

    public static int decrypt(int encrypted, int d, int n) {
        return modPow(encrypted, d, n);
    }

    public static int modPow(int base, int exponent, int modulus) {
        int result = 1;
        base = base % modulus;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result = (result * base) % modulus;
            }
            exponent = exponent >> 1;
            base = (base * base) % modulus;
        }
        return result;
    }

    public static int modInverse(int a, int m) {
        int m0 = m;
        int y = 0, x = 1;
        if (m == 1) return 0;
        while (a > 1) {
            int q = a / m;
            int t = m;
            m = a % m;
            a = t;
            t = y;
            y = x - q * y;
            x = t;
        }
        if (x < 0) x += m0;
        return x;
    }
}