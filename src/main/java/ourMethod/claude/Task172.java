package ourMethod.claude;

import java.util.HashSet;
import java.util.Set;

public class Task172 {
    public static int distinctEchoSubstrings(String text) {
        if (text == null || text.length() == 0) {
            return 0;
        }
        
        // Validate input: only lowercase English letters
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 'a' || c > 'z') {
                throw new IllegalArgumentException("Input must contain only lowercase English letters");
            }
        }
        
        Set<String> distinctSubstrings = new HashSet<>();
        int n = text.length();
        
        // Iterate through all possible substring lengths (must be even)
        for (int len = 2; len <= n; len += 2) {
            int halfLen = len / 2;
            
            // Iterate through all starting positions
            for (int i = 0; i <= n - len; i++) {
                String firstHalf = text.substring(i, i + halfLen);
                String secondHalf = text.substring(i + halfLen, i + len);
                
                if (firstHalf.equals(secondHalf)) {
                    distinctSubstrings.add(text.substring(i, i + len));
                }
            }
        }
        
        return distinctSubstrings.size();
    }
    
    public static void main(String[] args) {
        // Test case 1
        String test1 = "abcabcabc";
        System.out.println("Input: \"" + test1 + "\" Output: " + distinctEchoSubstrings(test1));
        
        // Test case 2
        String test2 = "leetcodeleetcode";
        System.out.println("Input: \"" + test2 + "\" Output: " + distinctEchoSubstrings(test2));
        
        // Test case 3
        String test3 = "aaaa";
        System.out.println("Input: \"" + test3 + "\" Output: " + distinctEchoSubstrings(test3));
        
        // Test case 4
        String test4 = "a";
        System.out.println("Input: \"" + test4 + "\" Output: " + distinctEchoSubstrings(test4));
        
        // Test case 5
        String test5 = "abab";
        System.out.println("Input: \"" + test5 + "\" Output: " + distinctEchoSubstrings(test5));
    }
}
