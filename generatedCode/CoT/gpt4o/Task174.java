package CoT.openai;
public class Task174 {
    public static String shortestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        String rev = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + rev;
        int[] lps = computeLPSArray(combined);
        int lengthOfPalindrome = lps[lps.length - 1];
        String toAdd = rev.substring(0, rev.length() - lengthOfPalindrome);
        return toAdd + s;
    }

    private static int[] computeLPSArray(String pattern) {
        int[] lps = new int[pattern.length()];
        int length = 0;
        int i = 1;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        System.out.println(shortestPalindrome("aacecaaa")); // "aaacecaaa"
        System.out.println(shortestPalindrome("abcd")); // "dcbabcd"
        System.out.println(shortestPalindrome("racecar")); // "racecar"
        System.out.println(shortestPalindrome("a")); // "a"
        System.out.println(shortestPalindrome("")); // ""
    }
}