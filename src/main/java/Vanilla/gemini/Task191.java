package Vanilla.gemini;
class Task191 {
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        int n = s.length();
        int[] dp = new int[n];

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Task191 task = new Task191();
        System.out.println(task.longestValidParentheses("(()")); // 2
        System.out.println(task.longestValidParentheses(")()())")); // 4
        System.out.println(task.longestValidParentheses("")); // 0
        System.out.println(task.longestValidParentheses("()(())")); // 6
        System.out.println(task.longestValidParentheses("()(()")); // 2

    }
}