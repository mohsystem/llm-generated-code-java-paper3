package ourMethodv2.gpt4o;
public class Task174 {
    public static String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        String l = s + "#" + rev;
        int[] p = new int[l.length()];
        for (int i = 1; i < l.length(); i++) {
            int j = p[i - 1];
            while (j > 0 && l.charAt(i) != l.charAt(j)) {
                j = p[j - 1];
            }
            p[i] = (j += l.charAt(i) == l.charAt(j) ? 1 : 0);
        }
        return rev.substring(0, s.length() - p[l.length() - 1]) + s;
    }

    public static void main(String[] args) {
        System.out.println(shortestPalindrome("aacecaaa")); // Output: "aaacecaaa"
        System.out.println(shortestPalindrome("abcd"));     // Output: "dcbabcd"
        System.out.println(shortestPalindrome("racecar"));  // Output: "racecar"
        System.out.println(shortestPalindrome("abba"));     // Output: "abba"
        System.out.println(shortestPalindrome("a"));        // Output: "a"
    }
}