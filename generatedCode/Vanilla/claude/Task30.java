package Vanilla.claude;

public class Task30 {
    public static String longest(String s1, String s2) {
        String combined = s1 + s2;
        return combined.chars()
                      .distinct()
                      .mapToObj(ch -> String.valueOf((char)ch))
                      .sorted()
                      .reduce("", String::concat);
    }
    
    public static void main(String[] args) {
        System.out.println(longest("xyaabbbccccdefww", "xxxxyyyyabklmopq")); // "abcdefklmopqwxy"
        System.out.println(longest("abcdefghijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxyz")); // "abcdefghijklmnopqrstuvwxyz"
        System.out.println(longest("aretheyhere", "yestheyarehere")); // "aehrsty"
        System.out.println(longest("loopingisfunbutdangerous", "lessdangerousthancoding")); // "abcdefghilnoprstu" 
        System.out.println(longest("inmanylanguages", "theresapairoffunctions")); // "acefghilmnoprstuy"
    }
}
