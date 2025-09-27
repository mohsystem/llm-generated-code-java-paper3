package ourMethod.gemini;
import java.util.HashSet;
import java.util.Set;

public class Task172 {
    public int distinctEchoSubstrings(String text) {
        Set<String> distinctEchoSubstrings = new HashSet<>();
        int n = text.length();
        for (int len = 1; len <= n / 2; len++) {
            for (int i = 0; i <= n - 2 * len; i++) {
                String s1 = text.substring(i, i + len);
                String s2 = text.substring(i + len, i + 2 * len);
                if (s1.equals(s2)) {
                    distinctEchoSubstrings.add(s1 + s2);
                }
            }
        }
        return distinctEchoSubstrings.size();
    }

    public static void main(String[] args) {
        Task172 task172 = new Task172();
        String[] testCases = {"abcabcabc", "leetcodeleetcode", "abab", "aaa", "aaaba"};
        int[] expectedOutputs = {3, 2, 1, 1, 1};

        for (int i = 0; i < testCases.length; i++) {
            int output = task172.distinctEchoSubstrings(testCases[i]);
            System.out.println("Test case " + (i + 1) + ": " + testCases[i]);
            System.out.println("Expected output: " + expectedOutputs[i]);
            System.out.println("Actual output: " + output);
            System.out.println(output == expectedOutputs[i] ? "Pass" : "Fail");
            System.out.println();
        }
    }
}