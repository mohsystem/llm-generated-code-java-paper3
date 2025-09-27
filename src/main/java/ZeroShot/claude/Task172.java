package ZeroShot.claude;

import java.util.HashSet;

class Task172 {
    public static int countDistinctRepeatedSubstrings(String text) {
        HashSet<String> result = new HashSet<>();
        int n = text.length();
        
        for (int len = 2; len <= n; len += 2) {
            for (int i = 0; i <= n - len; i++) {
                String substring = text.substring(i, i + len);
                int halfLen = len / 2;
                String firstHalf = substring.substring(0, halfLen);
                String secondHalf = substring.substring(halfLen);
                
                if (firstHalf.equals(secondHalf)) {
                    result.add(substring);
                }
            }
        }
        
        return result.size();
    }

    public static void main(String[] args) {
        // Test cases
        String[] tests = {
            "abcabcabc",
            "leetcodeleetcode",
            "aa",
            "aabaabaa",
            "abcd"
        };
        
        for (String test : tests) {
            System.out.println("Input: " + test);
            System.out.println("Output: " + countDistinctRepeatedSubstrings(test));
            System.out.println();
        }
    }
}
