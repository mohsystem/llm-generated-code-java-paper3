package ZeroShot.claude;

public class Task173 {
    public static String longestDupSubstring(String s) {
        String result = "";
        if (s == null || s.length() < 2) return result;
        
        int n = s.length();
        for (int len = n-1; len > 0; len--) {
            for (int i = 0; i <= n-len; i++) {
                String substr = s.substring(i, i+len);
                String remaining = s.substring(i+1);
                if (remaining.contains(substr)) {
                    return substr;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(longestDupSubstring("banana")); // "ana"
        System.out.println(longestDupSubstring("abcd")); // ""
        System.out.println(longestDupSubstring("aaaa")); // "aaa"
        System.out.println(longestDupSubstring("aabaa")); // "aa"
        System.out.println(longestDupSubstring("mississippi")); // "issi"
    }
}
