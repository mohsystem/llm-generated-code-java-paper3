package ourMethod.claude;

public class Task172 {
    public static int countRepeatedSubstrings(String text) {
        if (text == null || text.length() < 2) {
            return 0;
        }
        
        java.util.HashSet<String> result = new java.util.HashSet<>();
        int n = text.length();
        
        // Check all possible substrings of even length
        for (int i = 0; i < n; i++) {
            for (int len = 2; i + len <= n && len % 2 == 0; len += 2) {
                String substr = text.substring(i, i + len);
                String firstHalf = substr.substring(0, len/2);
                String secondHalf = substr.substring(len/2);
                if (firstHalf.equals(secondHalf)) {
                    result.add(substr);
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
            System.out.println("Output: " + countRepeatedSubstrings(test));
            System.out.println();
        }
    }
}
