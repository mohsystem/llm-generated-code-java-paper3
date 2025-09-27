package ourMethod.gemini;
import java.util.*;

class Task174 {
    public String shortestPalindrome(String s) {
        int n = s.length();
        String reversed_s = new StringBuilder(s).reverse().toString();
        for (int i = 0; i < n; i++) {
            if (s.substring(0, n - i).equals(reversed_s.substring(i))) {
                return reversed_s.substring(0, i) + s;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Task174 solution = new Task174();

        String testCase1 = "aacecaaa";
        String expected1 = "aaacecaaa";
        String result1 = solution.shortestPalindrome(testCase1);
        System.out.println("Test Case 1: " + (result1.equals(expected1) ? "Passed" : "Failed"));

        String testCase2 = "abcd";
        String expected2 = "dcbabcd";
        String result2 = solution.shortestPalindrome(testCase2);
        System.out.println("Test Case 2: " + (result2.equals(expected2) ? "Passed" : "Failed"));

        String testCase3 = "racecar";
        String expected3 = "racecar";
        String result3 = solution.shortestPalindrome(testCase3);
        System.out.println("Test Case 3: " + (result3.equals(expected3) ? "Passed" : "Failed"));

        String testCase4 = "";
        String expected4 = "";
        String result4 = solution.shortestPalindrome(testCase4);
        System.out.println("Test Case 4: " + (result4.equals(expected4) ? "Passed" : "Failed"));

        String testCase5 = "a";
        String expected5 = "a";
        String result5 = solution.shortestPalindrome(testCase5);
        System.out.println("Test Case 5: " + (result5.equals(expected5) ? "Passed" : "Failed"));
    }
}