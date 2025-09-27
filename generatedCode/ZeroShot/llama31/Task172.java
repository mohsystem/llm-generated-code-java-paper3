package ZeroShot.llama31;
public class Task172 {
    public static int distinctEchoSubstrings(String text) {
        int n = text.length();
        boolean[][] isEcho = new boolean[n][n];
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (len % 2 == 0 && text.substring(i, i + len / 2).equals(text.substring(i + len / 2, j + 1))) {
                    isEcho[i][j] = true;
                } else if (len % 2 != 0 && text.substring(i, i + len / 2).equals(text.substring(i + len / 2 + 1, j + 1))) {
                    isEcho[i][j] = true;
                }
            }
        }

        int count = 0;
        for (int len = 2; len <= n; len += 2) {
            for (int i = 0; i <= n - len; i++) {
                if (isEcho[i][i + len - 1]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(distinctEchoSubstrings("abcabcabc")); // Output: 3
        System.out.println(distinctEchoSubstrings("leetcodeleetcode")); // Output: 2
        System.out.println(distinctEchoSubstrings("aaaaaa")); // Output: 3
        System.out.println(distinctEchoSubstrings("abababab")); // Output: 2
        System.out.println(distinctEchoSubstrings("xyzxyzxyz")); // Output: 1
    }
}