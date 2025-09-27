package ourMethod.llama31;
public class Task191 {
    public static int longestValidParentheses(String s) {
        int maxLen = 0;
        int[] dp = new int[s.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i - 1) == ')') {
                if (s.charAt(i - 2) == '(') {
                    dp[i] = dp[i - 2] + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()")); // Output: 2
        System.out.println(longestValidParentheses(")()())")); // Output: 4
        System.out.println(longestValidParentheses("")); // Output: 0
    }
}