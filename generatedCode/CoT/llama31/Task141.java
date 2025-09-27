package CoT.llama31;
public class Task141 {
    public static String reverseString(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            res.append(s.charAt(i));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String[] testCases = {"abdcfe", "Hello World", "Geeks for Geeks", "Python", "Java"};
        for (String testCase : testCases) {
            System.out.println("Input: " + testCase + ", Output: " + reverseString(testCase));
        }
    }
}