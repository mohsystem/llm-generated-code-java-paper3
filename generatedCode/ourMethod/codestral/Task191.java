package ourMethod.codestral;
import java.util.Stack;

public class Task191 {
    public static int longestValidParentheses(String s) {
        int maxLen = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    maxLen = Math.max(maxLen, i - stack.peek());
                } else {
                    stack.push(i);
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()")); // Output: 2
        System.out.println(longestValidParentheses(")()())")); // Output: 4
        System.out.println(longestValidParentheses("")); // Output: 0
        System.out.println(longestValidParentheses("(")); // Output: 0
        System.out.println(longestValidParentheses(")")); // Output: 0
    }
}