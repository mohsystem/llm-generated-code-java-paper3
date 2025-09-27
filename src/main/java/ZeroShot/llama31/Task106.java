package ZeroShot.llama31;
public class Task106 {
    public static void main(String[] args) {
        // Test cases
        int[] testCases = {17, 19, 23, 29, 31};
        for (int testCase : testCases) {
            int p = 61;
            int q = 53;
            int e = testCase;
            int[] keys = generateKeys(p, q, e);
            int n = keys[0];
            int d = keys[1];
            int publicKey[] = {n, e};
            int privateKey[] = {n, d};

            int message = 12;
            int encrypted = encrypt(publicKey, message);
            int decrypted = decrypt(privateKey, encrypted);

            System.out.println("Public Key: (" + n + ", " + e + ")");
            System.out.println("Private Key: (" + n + ", " + d + ")");
            System.out.println("Message: " + message);
            System.out.println("Encrypted: " + encrypted);
            System.out.println("Decrypted: " + decrypted);
            System.out.println();
        }
    }

    public static int[] generateKeys(int p, int q, int e) {
        int n = p * q;
        int phi = (p - 1) * (q - 1);
        int d = modInverse(e, phi);
        return new int[]{n, d};
    }

    public static int modInverse(int a, int m) {
        int m0 = m;
        int y = 0, x = 1;
        if (m == 1)
            return 0;
        while (a > 1) {
            int q = a / m;
            int t = m;
            m = a % m;
            a = t;
            t = y;
            y = x - q * y;
            x = t;
        }
        if (x < 0)
            x += m0;
        return x;
    }

    public static int encrypt(int[] publicKey, int message) {
        int n = publicKey[0];
        int e = publicKey[1];
        return power(message, e, n);
    }

    public static int decrypt(int[] privateKey, int ciphertext) {
        int n = privateKey[0];
        int d = privateKey[1];
        return power(ciphertext, d, n);
    }

    public static int power(int base, int exponent, int mod) {
        int result = 1;
        base = base % mod;
        while (exponent > 0) {
            if ((exponent & 1) == 1)
                result = (result * base) % mod;
            exponent = exponent >> 1;
            base = (base * base) % mod;
        }
        return result;
    }
}