package Vanilla.llama31;
public class Task106 {
    public static void main(String[] args) {
        // Test cases
        int[] testCases = {17, 19, 61, 53, 59};
        for (int i = 0; i < testCases.length; i++) {
            int p = testCases[i];
            int q = testCases[(i + 1) % testCases.length];
            RSA rsa = new RSA(p, q);
            String message = "Hello, RSA!";
            String encrypted = rsa.encrypt(message);
            String decrypted = rsa.decrypt(encrypted);
            System.out.println("Original Message: " + message);
            System.out.println("Encrypted Message: " + encrypted);
            System.out.println("Decrypted Message: " + decrypted);
            System.out.println();
        }
    }

    public static class RSA {
        private int n, e, d;

        public RSA(int p, int q) {
            n = p * q;
            int phi = (p - 1) * (q - 1);
            e = 2;
            while (gcd(e, phi) != 1) {
                e++;
            }
            d = modInverse(e, phi);
        }

        public String encrypt(String message) {
            StringBuilder encrypted = new StringBuilder();
            for (char c : message.toCharArray()) {
                int m = c;
                int cText = modPow(m, e, n);
                encrypted.append(cText).append(" ");
            }
            return encrypted.toString().trim();
        }

        public String decrypt(String encrypted) {
            String[] parts = encrypted.split(" ");
            StringBuilder decrypted = new StringBuilder();
            for (String part : parts) {
                int cText = Integer.parseInt(part);
                int m = modPow(cText, d, n);
                decrypted.append((char) m);
            }
            return decrypted.toString();
        }

        private int gcd(int a, int b) {
            if (b == 0) return a;
            return gcd(b, a % b);
        }

        private int modInverse(int a, int m) {
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

        private int modPow(int base, int exponent, int mod) {
            int result = 1;
            base = base % mod;
            while (exponent > 0) {
                if ((exponent & 1) == 1)
                    result = (result * base) % mod;
                base = (base * base) % mod;
                exponent >>= 1;
            }
            return result;
        }
    }
}