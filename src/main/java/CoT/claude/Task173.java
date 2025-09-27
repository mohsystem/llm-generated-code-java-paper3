package CoT.claude;

public class Task173 {
    public static String longestDupSubstring(String s) {
        if (s == null || s.length() < 2) return "";
        
        String result = "";
        for (int len = s.length() - 1; len > 0; len--) {
            for (int i = 0; i + len <= s.length(); i++) {
                String substr = s.substring(i, i + len);
                String remaining = s.substring(i + 1);
                if (remaining.contains(substr)) {
                    return substr;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(longestDupSubstring("banana")); // Expected: "ana"
        System.out.println(longestDupSubstring("abcd")); // Expected: ""
        System.out.println(longestDupSubstring("aaa")); // Expected: "aa"
        System.out.println(longestDupSubstring("aaaa")); // Expected: "aaa"
        System.out.println(longestDupSubstring("ababa")); // Expected: "aba"
    }
}
