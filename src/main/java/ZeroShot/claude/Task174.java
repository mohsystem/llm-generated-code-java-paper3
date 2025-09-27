package ZeroShot.claude;

public class Task174 {
    public static String shortestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        
        String temp = s + "#" + new StringBuilder(s).reverse().toString();
        int[] lps = new int[temp.length()];
        
        // Build LPS array
        for (int i = 1; i < temp.length(); i++) {
            int len = lps[i-1];
            while (len > 0 && temp.charAt(len) != temp.charAt(i)) {
                len = lps[len-1];
            }
            if (temp.charAt(len) == temp.charAt(i)) {
                len++;
            }
            lps[i] = len;
        }
        
        return new StringBuilder(s.substring(lps[temp.length()-1])).reverse().toString() + s;
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(shortestPalindrome("aacecaaa")); // aaacecaaa
        System.out.println(shortestPalindrome("abcd")); // dcbabcd
        System.out.println(shortestPalindrome("")); // ""
        System.out.println(shortestPalindrome("a")); // a
        System.out.println(shortestPalindrome("aba")); // aba
    }
}
