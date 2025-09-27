package CoT.codestral;
public class Task174 {
    public static String shortestPalindrome(String s) {
        int i = 0;
        for (int j = s.length() - 1; j >= 0; j--) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
            }
        }
        if (i == s.length()) {
            return s;
        }
        String suffix = s.substring(i);
        String prefix = new StringBuilder(suffix).reverse().toString();
        return prefix + shortestPalindrome(s.substring(0, i)) + suffix;
    }

    public static void main(String[] args) {
        System.out.println(shortestPalindrome("aacecaaa")); // Output: "aaacecaaa"
        System.out.println(shortestPalindrome("abcd")); // Output: "dcbabcd"
    }
}