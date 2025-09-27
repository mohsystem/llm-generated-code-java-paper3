package Vanilla.claude;

public class Task174 {
    public static String shortestPalindrome(String s) {
        String temp = s + "#" + new StringBuilder(s).reverse().toString();
        int[] lps = new int[temp.length()];
        int len = 0;
        int i = 1;
        
        while(i < temp.length()) {
            if(temp.charAt(i) == temp.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else {
                if(len != 0) {
                    len = lps[len-1];
                }
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        return new StringBuilder(s.substring(lps[temp.length()-1])).reverse().toString() + s;
    }
    
    public static void main(String[] args) {
        System.out.println(shortestPalindrome("aacecaaa")); // "aaacecaaa"
        System.out.println(shortestPalindrome("abcd")); // "dcbabcd"
        System.out.println(shortestPalindrome("aaa")); // "aaa"
        System.out.println(shortestPalindrome("aaaa")); // "aaaa" 
        System.out.println(shortestPalindrome("")); // ""
    }
}
