package ZeroShot.llama31;
public class Task174 {
    public static String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        for (int i = 0; i <= s.length(); i++) {
            if (s.startsWith(rev.substring(i))) {
                return rev.substring(0, i) + s;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(shortestPalindrome("aacecaaa")); // "aaacecaaa"
        System.out.println(shortestPalindrome("abcd")); // "dcbabcd"
        System.out.println(shortestPalindrome("a")); // "a"
        System.out.println(shortestPalindrome("aa")); // "aa"
        System.out.println(shortestPalindrome("abcddcba")); // "abcddcba"
    }
}