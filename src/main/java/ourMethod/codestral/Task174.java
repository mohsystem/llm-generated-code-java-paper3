package ourMethod.codestral;
public class Task174 {
    public static String shortestPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (j >= 0) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
            }
            j--;
        }
        if (i == s.length()) {
            return s;
        }
        String suffix = s.substring(i);
        return new StringBuilder(suffix).reverse().toString() + shortestPalindrome(s.substring(0, i)) + suffix;
    }

    public static void main(String[] args) {
        System.out.println(shortestPalindrome("aacecaaa")); // Expected: aaacecaaa
        System.out.println(shortestPalindrome("abcd")); // Expected: dcbabcd
    }
}