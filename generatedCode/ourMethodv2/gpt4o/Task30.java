package ourMethodv2.gpt4o;
public class Task30 {
    public static String longest(String s1, String s2) {
        String combined = s1 + s2;
        return combined.chars()
                       .distinct()
                       .sorted()
                       .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                       .toString();
    }

    public static void main(String[] args) {
        System.out.println(longest("xyaabbbccccdefww", "xxxxyyyyabklmopq")); // "abcdefklmopqwxy"
        System.out.println(longest("abcdefghijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxyz")); // "abcdefghijklmnopqrstuvwxyz"
        System.out.println(longest("a", "b")); // "ab"
        System.out.println(longest("z", "y")); // "yz"
        System.out.println(longest("abc", "def")); // "abcdef"
    }
}