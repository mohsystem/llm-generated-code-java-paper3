package ourMethod.openai;
public class Task174 {
    public static String shortestPalindrome(String s) {
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(j)) {
                j += 1;
            }
        }
        if (j == s.length()) return s;
        String suffix = s.substring(j);
        return new StringBuilder(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
    }

    public static void main(String[] args) {
        System.out.println(shortestPalindrome("aacecaaa")); // aaacecaaa
        System.out.println(shortestPalindrome("abcd"));     // dcbabcd
        System.out.println(shortestPalindrome("abcba"));    // abcba
        System.out.println(shortestPalindrome("race"));     // ecarrace
        System.out.println(shortestPalindrome(""));         // ""
    }
}