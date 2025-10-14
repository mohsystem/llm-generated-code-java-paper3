package ZeroShot.openai;
public class Task174 {
    public static void main(String[] args) {
        System.out.println(shortestPalindrome("aacecaaa")); // Output: "aaacecaaa"
        System.out.println(shortestPalindrome("abcd")); // Output: "dcbabcd"
        System.out.println(shortestPalindrome("racecar")); // Output: "racecar"
        System.out.println(shortestPalindrome("")); // Output: ""
        System.out.println(shortestPalindrome("a")); // Output: "a"
    }

    public static String shortestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        String reversed = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + reversed;
        int[] lps = computeLPSArray(combined);
        int maxPrefixLength = lps[lps.length - 1];

        return reversed.substring(0, s.length() - maxPrefixLength) + s;
    }

    private static int[] computeLPSArray(String str) {
        int[] lps = new int[str.length()];
        int length = 0;
        int i = 1;
        while (i < str.length()) {
            if (str.charAt(i) == str.charAt(length)) {
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
}