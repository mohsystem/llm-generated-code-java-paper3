package CoT.llama31;
public class Task173 {
    public static String longestDupSubstring(String s) {
        int n = s.length();
        String longest = "";
        for (int len = n / 2; len > 0; len--) {
            for (int i = 0; i <= n - len; i++) {
                String substr = s.substring(i, i + len);
                if (s.indexOf(substr, i + 1) != -1 && substr.length() > longest.length()) {
                    longest = substr;
                }
            }
            if (!longest.isEmpty()) {
                break;
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(longestDupSubstring("banana")); // "ana"
        System.out.println(longestDupSubstring("abcd")); // ""
        System.out.println(longestDupSubstring("aabbcc")); // "bb"
        System.out.println(longestDupSubstring("abcabc")); // "abc"
        System.out.println(longestDupSubstring("abcdef")); // ""
    }
}