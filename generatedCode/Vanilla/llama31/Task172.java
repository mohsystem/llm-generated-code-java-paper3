package Vanilla.llama31;
public class Task172 {
    public static int distinctEchoSubstrings(String text) {
        int n = text.length();
        boolean[][] isEcho = new boolean[n][n];
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (len % 2 == 0 && text.substring(i, i + len / 2).equals(text.substring(i + len / 2, j + 1))) {
                    isEcho[i][j] = true;
                } else if (len % 2 == 1 && text.substring(i, i + len / 2).equals(text.substring(i + len / 2 + 1, j + 1))) {
                    isEcho[i][j] = true;
                }
            }
        }

        boolean[] isDistinct = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isEcho[i][j] && !isDistinct[j]) {
                    isDistinct[j] = true;
                }
            }
        }

        int count = 0;
        for (boolean b : isDistinct) {
            if (b) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(distinctEchoSubstrings("abcabcabc")); // Output: 3
        System.out.println(distinctEchoSubstrings("leetcodeleetcode")); // Output: 2
        System.out.println(distinctEchoSubstrings("aaa")); // Output: 2
        System.out.println(distinctEchoSubstrings("abcdabcd")); // Output: 2
        System.out.println(distinctEchoSubstrings("ababab")); // Output: 3
    }
}