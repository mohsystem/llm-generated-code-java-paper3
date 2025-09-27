package CoT.llama31;
public class Task191 {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        int maxLen = 0;
        for (int i = 2; i <= n; i++) {
            if (s.charAt(i - 1) == ')') {
                if (s.charAt(i - 2) == '(') {
                    dp[i] = dp[i - 2] + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Task191 task = new Task191();
        System.out.println(task.longestValidParentheses("(()")); // Output: 2
        System.out.println(task.longestValidParentheses(")()())")); // Output: 4
        System.out.println(task.longestValidParentheses("")); // Output: 0
        System.out.println(task.longestValidParentheses(")()()(")); // Output: 4
        System.out.println(task.longestValidParentheses("((())")); // Output: 4
    }
}