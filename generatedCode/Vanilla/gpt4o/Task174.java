package Vanilla.openai;
public class Task174 {
    public static String shortestPalindrome(String s) {
        int n = s.length();
        String rev = new StringBuilder(s).reverse().toString();
        String l = s + "#" + rev;
        int[] p = new int[l.length()];
        
        for (int i = 1; i < l.length(); i++) {
            int j = p[i - 1];
            while (j > 0 && l.charAt(i) != l.charAt(j)) {
                j = p[j - 1];
            }
            if (l.charAt(i) == l.charAt(j)) {
                j++;
            }
            p[i] = j;
        }
        
        return rev.substring(0, n - p[l.length() - 1]) + s;
    }

    public static void main(String[] args) {
        System.out.println(shortestPalindrome("aacecaaa")); // "aaacecaaa"
        System.out.println(shortestPalindrome("abcd")); // "dcbabcd"
        System.out.println(shortestPalindrome("racecar")); // "racecar"
        System.out.println(shortestPalindrome("")); // ""
        System.out.println(shortestPalindrome("a")); // "a"
    }
}