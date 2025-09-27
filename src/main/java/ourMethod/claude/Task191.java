package ourMethod.claude;

public class Task191 {
    public static int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        
        int maxLength = 0;
        int[] dp = new int[s.length()];
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i-1) == '(') {
                    dp[i] = (i >= 2 ? dp[i-2] : 0) + 2;
                }
                else if (i - dp[i-1] > 0 && s.charAt(i - dp[i-1] - 1) == '(') {
                    dp[i] = dp[i-1] + 2 + 
                            ((i - dp[i-1] >= 2) ? dp[i - dp[i-1] - 2] : 0);
                }
                maxLength = Math.max(maxLength, dp[i]);
            }
        }
        return maxLength;
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(longestValidParentheses("(()"));     // Expected: 2
        System.out.println(longestValidParentheses(")()())"));  // Expected: 4  
        System.out.println(longestValidParentheses(""));        // Expected: 0
        System.out.println(longestValidParentheses("()(()"));   // Expected: 2
        System.out.println(longestValidParentheses("(()())"));  // Expected: 6
    }
}
