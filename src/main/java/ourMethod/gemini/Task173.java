package ourMethod.gemini;
import java.util.HashSet;
import java.util.Set;

public class Task173 {
    public String longestDupSubstring(String s) {
        int n = s.length();
        int left = 1;
        int right = n - 1;
        String result = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            String dup = findDuplicateSubstring(s, mid);
            if (!dup.isEmpty()) {
                result = dup;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    private String findDuplicateSubstring(String s, int len) {
        int n = s.length();
        Set<String> seen = new HashSet<>();
        for (int i = 0; i <= n - len; i++) {
            String sub = s.substring(i, i + len);
            if (seen.contains(sub)) {
                return sub;
            }
            seen.add(sub);
        }
        return "";
    }

    public static void main(String[] args) {
        Task173 task173 = new Task173();
        String[] testCases = {"banana", "abcd", "abracadabra", "aabaab", "aaaaaaaa"};
        String[] expectedOutputs = {"ana", "", "abra", "aab", "aaaaaaa"};

        for (int i = 0; i < testCases.length; i++) {
            String output = task173.longestDupSubstring(testCases[i]);
            System.out.println("Test case " + (i + 1) + ": Input - " + testCases[i] + ", Output - " + output +
                    ", Expected - " + expectedOutputs[i]);
            assert output.equals(expectedOutputs[i]) : "Test case " + (i + 1) + " failed";
        }

        System.out.println("All test cases passed.");


    }
}