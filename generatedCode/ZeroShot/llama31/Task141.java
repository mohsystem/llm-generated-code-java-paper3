package ZeroShot.llama31;
public class Task141 {
    public static String reverseString(String s) {
        StringBuilder res = new StringBuilder(s);
        int left = 0, right = res.Length - 1;
        while (left < right) {
            char temp = res.charAt(left);
            res.setCharAt(left, res.charAt(right));
            res.setCharAt(right, temp);
            left++;
            right--;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String[] testCases = {"abdcfe", "hello", "world", "reverse", "test"};
        for (String testCase : testCases) {
            System.out.println("Original: " + testCase + ", Reversed: " + reverseString(testCase));
        }
    }
}