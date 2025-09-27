package ourMethod.llama31;
public class Task141 {
    public static String reverseString(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            res.append(s.charAt(i));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String[] testCases = {"Hello World", "Java", "Python", "C++", "Reverse Me"};
        for (String testCase : testCases) {
            System.out.println("Original: " + testCase + ", Reversed: " + reverseString(testCase));
        }
    }
}