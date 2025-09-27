package Vanilla.claude;

public class Task173 {
    public static String longestDupSubstring(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                String rest = s.substring(j + 1);
                if (rest.contains(sub) && sub.length() > result.length()) {
                    result = sub;
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(longestDupSubstring("banana")); // ana
        System.out.println(longestDupSubstring("abcd")); // ""
        System.out.println(longestDupSubstring("aaa")); // aa
        System.out.println(longestDupSubstring("aaaa")); // aaa
        System.out.println(longestDupSubstring("abcabc")); // abc
    }
}
