package ourMethod.claude;

public class Task173 {
    public static String longestDupSubstring(String s) {
        if (s == null || s.length() < 2) {
            return "";
        }
        
        String result = "";
        int n = s.length();
        
        // For each possible length of substring
        for (int len = 1; len < n; len++) {
            // For each starting position
            for (int i = 0; i <= n - len; i++) {
                String substr = s.substring(i, i + len);
                // Check if this substring appears again in remaining string
                String remaining = s.substring(i + 1);
                if (remaining.contains(substr)) {
                    if (substr.length() > result.length()) {
                        result = substr;
                    }
                }
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(longestDupSubstring("banana")); // Expected: "ana"
        System.out.println(longestDupSubstring("abcd")); // Expected: ""
        System.out.println(longestDupSubstring("aa")); // Expected: "a"
        System.out.println(longestDupSubstring("aaa")); // Expected: "aa"
        System.out.println(longestDupSubstring("aaaaa")); // Expected: "aaaa"
    }
}
