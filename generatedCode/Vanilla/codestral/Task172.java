package Vanilla.codestral;
class Task172 {
    public static int distinctEchoSubstrings(String text) {
        int n = text.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (len % 2 == 0 && (len / 2 <= i || dp[i + 1][i + len / 2 - 1])) {
                    dp[i][j] = text.substring(i, i + len / 2).equals(text.substring(i + len / 2, i + len));
                    if (dp[i][j]) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(distinctEchoSubstrings("abcabcabc")); // Output: 3
        System.out.println(distinctEchoSubstrings("leetcodeleetcode")); // Output: 2
    }
}