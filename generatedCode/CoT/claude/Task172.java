package CoT.claude;

public class Task172 {
    public static int distinctSubstrings(String text) {
        int n = text.length();
        java.util.HashSet<String> result = new java.util.HashSet<>();
        
        // Check all possible substrings
        for(int len = 2; len <= n; len += 2) {
            for(int i = 0; i + len <= n; i++) {
                String substr = text.substring(i, i + len);
                if(len % 2 == 0) {
                    String firstHalf = substr.substring(0, len/2);
                    String secondHalf = substr.substring(len/2);
                    if(firstHalf.equals(secondHalf)) {
                        result.add(substr);
                    }
                }
            }
        }
        return result.size();
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(distinctSubstrings("abcabcabc")); // Expected: 3
        System.out.println(distinctSubstrings("leetcodeleetcode")); // Expected: 2
        System.out.println(distinctSubstrings("aa")); // Expected: 1
        System.out.println(distinctSubstrings("aaa")); // Expected: 1
        System.out.println(distinctSubstrings("aabaabaa")); // Expected: 2
    }
}
