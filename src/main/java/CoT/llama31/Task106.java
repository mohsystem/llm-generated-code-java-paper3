package CoT.llama31;
import java.math.BigInteger;

public class Task106 {
    public static void main(String[] args) {
        int p = 3;
        int q = 11;
        int msg = 12;

        // Test cases
        int[][] testCases = {
            {3, 11, 12},
            {5, 7, 25},
            {7, 11, 30},
            {11, 13, 40},
            {13, 17, 50}
        };

        for (int[] testCase : testCases) {
            p = testCase[0];
            q = testCase[1];
            msg = testCase[2];
            rsaEncryptDecrypt(p, q, msg);
        }
    }

    public static void rsaEncryptDecrypt(int p, int q, int msg) {
        int n = p * q;
        int phi = (p - 1) * (q - 1);
        int e = 2;
        while (gcd(e, phi) != 1) {
            e++;
        }
        int d = modInverse(e, phi);

        int encrypted = encrypt(msg, e, n);
        int decrypted = decrypt(encrypted, d, n);

        System.out.println("p: " + p + ", q: " + q + ", msg: " + msg);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
        System.out.println();
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
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

    public static int encrypt(int msg, int e, int n) {
        return BigInteger.valueOf(msg).modPow(BigInteger.valueOf(e), BigInteger.valueOf(n)).intValue();
    }

    public static int decrypt(int encrypted, int d, int n) {
        return BigInteger.valueOf(encrypted).modPow(BigInteger.valueOf(d), BigInteger.valueOf(n)).intValue();
    }
}