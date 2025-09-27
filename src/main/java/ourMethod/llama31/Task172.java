package ourMethod.llama31;
public class Task172 {
    public static void main(String[] args) {
        System.out.println(countDistinctSubstrings("abcabcabc")); // Output: 3
        System.out.println(countDistinctSubstrings("leetcodeleetcode")); // Output: 2
    }

    public static int countDistinctSubstrings(String text) {
        int n = text.length();
        boolean[][] isConcat = new boolean[n][n];
        int count = 0;

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (len % 2 == 0 && text.substring(i, i + len / 2).equals(text.substring(i + len / 2, j + 1))) {
                    isConcat[i][j] = true;
                } else if (len % 2 != 0 && text.substring(i, i + len / 2 + 1).equals(text.substring(i + len / 2 + 1, j + 1))) {
                    isConcat[i][j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isConcat[i][j] && (j == i || !isConcat[i][j - 1])) {
                    count++;
                }
            }
        }

        return count;
    }
}