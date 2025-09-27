package CoT.llama31;
// Java code
public class Task30 {
    public static void main(String[] args) {
        System.out.println(longest("xyaabbbccccdefww", "xxxxyyyyabklmopq")); // "abcdefklmopqwxy"
        System.out.println(longest("abcdefghijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxyz")); // "abcdefghijklmnopqrstuvwxyz"
        System.out.println(longest("abc", "def")); // "abcdef"
        System.out.println(longest("a", "b")); // "ab"
        System.out.println(longest("", "abc")); // "abc"
    }

    public static String longest(String s1, String s2) {
        String combined = s1 + s2;
        char[] chars = combined.toCharArray();
        java.util.Arrays.sort(chars);
        StringBuilder result = new StringBuilder();
        for (char c : chars) {
            if (result.length() == 0 || c != result.charAt(result.length() - 1)) {
                result.append(c);
            }
        }
        return result.toString();
    }
}