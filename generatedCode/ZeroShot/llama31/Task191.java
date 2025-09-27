package ZeroShot.llama31;
public class Task191 {
    public static int longestValidParentheses(String s) {
        int maxLen = 0;
        int[] stack = new int[s.length() + 1];
        int top = 0;
        stack[top++] = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack[top++] = i;
            } else {
                top--;
                if (top == 0) {
                    stack[top++] = i;
                } else {
                    maxLen = Math.max(maxLen, i - stack[top - 1]);
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()")); // Output: 2
        System.out.println(longestValidParentheses(")()())")); // Output: 4
        System.out.println(longestValidParentheses("")); // Output: 0
        System.out.println(longestValidParentheses("((())")); // Output: 4
        System.out.println(longestValidParentheses(")()()(")); // Output: 4
    }
}