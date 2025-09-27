package CoT.llama31;
public class Task174 {
    public static String shortestPalindrome(String s) {
        int n = s.length();
        String rev = new StringBuilder(s).reverse().toString();
        s = s + "$" + rev;
        int[] lps = computeLPSArray(s);
        return rev.substring(0, n - lps[n + 1]) + s;
    }

    public static int[] computeLPSArray(String pat) {
        int n = pat.length();
        int[] lps = new int[n];
        lps[0] = 0;
        int len = 0;
        int i = 1;
        while (i < n) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
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
        System.out.println(shortestPalindrome("abc")); // "cbaabc"
        System.out.println(shortestPalindrome("racecar")); // "racecar"
        System.out.println(shortestPalindrome("")); // ""
    }
}