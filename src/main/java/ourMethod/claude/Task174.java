package ourMethod.claude;

public class Task174 {
    public static String shortestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        
        // Create a new string with special character to avoid overlapping
        String temp = s + "#" + new StringBuilder(s).reverse().toString();
        int[] lps = new int[temp.length()];
        
        // Compute KMP pattern array
        for (int i = 1, len = 0; i < temp.length();) {
            if (temp.charAt(i) == temp.charAt(len)) {
                lps[i++] = ++len;
            } else {
                if (len > 0) {
                    len = lps[len - 1];
                } else {
                    lps[i++] = 0;
                }
            }
        }
        
        // Get the length of longest palindrome starting from beginning
        int longest = lps[temp.length() - 1];
        
        // Add remaining characters in front
        return new StringBuilder(s.substring(longest))
            .reverse()
            .append(s)
            .toString();
    }
    
    public static void main(String[] args) {
        // Test cases
        String[] tests = {
            "aacecaaa",
            "abcd",
            "",
            "a",
            "aa"
        };
        
        for (String test : tests) {
            System.out.println("Input: " + test);
            System.out.println("Output: " + shortestPalindrome(test));
            System.out.println();
        }
    }
}
