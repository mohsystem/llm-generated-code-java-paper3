package Vanilla.llama31;
public class Task30 {
    public static void main(String[] args) {
        System.out.println(longest("xyaabbbccccdefww", "xxxxyyyyabklmopq")); // "abcdefklmopqwxy"
        System.out.println(longest("abcdefghijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxyz")); // "abcdefghijklmnopqrstuvwxyz"
        System.out.println(longest("abc", "def")); // "abcdef"
        System.out.println(longest("abc", "abc")); // "abc"
        System.out.println(longest("", "abcdef")); // "abcdef"
    }

    public static String longest(String s1, String s2) {
        String combined = s1 + s2;
        StringBuilder result = new StringBuilder();
        for (char c = 'a'; c <= 'z'; c++) {
            if (combined.indexOf(c) != -1) {
                result.append(c);
            }
        }
        return result.toString();
    }
}