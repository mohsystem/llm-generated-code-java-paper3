package ZeroShot.llama31;
public class Task51 {
    public static String encryption(String s) {
        int l = s.length();
        int b = (int) Math.ceil(Math.sqrt(l));
        int a = (int) Math.floor(Math.sqrt(l));
        if (b * a < l) {
            if (Math.min(b, a) == b) {
                b = b + 1;
            } else {
                a = a + 1;
            }
        }
        char[][] arr = new char[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (i * b + j < l) {
                    arr[i][j] = s.charAt(i * b + j);
                }
            }
        }
        String encrypted = "";
        for (int j = 0; j < b; j++) {
            for (int i = 0; i < a; i++) {
                encrypted += arr[i][j];
            }
        }
        return encrypted;
    }

    public static String decryption(String s) {
        int l = s.length();
        int b = (int) Math.ceil(Math.sqrt(l));
        int a = (int) Math.floor(Math.sqrt(l));
        if (b * a < l) {
            if (Math.min(b, a) == b) {
                b = b + 1;
            } else {
                a = a + 1;
            }
        }
        char[][] arr = new char[a][b];
        int k = 0;
        for (int j = 0; j < b; j++) {
            for (int i = 0; i < a; i++) {
                if (k < l) {
                    arr[i][j] = s.charAt(k);
                    k++;
                }
            }
        }
        String decrypted = "";
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                decrypted += arr[i][j];
            }
        }
        return decrypted;
    }

    public static void main(String[] args) {
        String[] testCases = {"hello", "world", "encryption", "decryption", "testcase"};
        for (String s : testCases) {
            String encrypted = encryption(s);
            String decrypted = decryption(encrypted);
            System.out.println("Original: " + s);
            System.out.println("Encrypted: " + encrypted);
            System.out.println("Decrypted: " + decrypted);
            System.out.println();
        }
    }
}