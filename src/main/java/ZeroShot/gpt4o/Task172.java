package ZeroShot.gpt4o;
import java.util.HashSet;
import java.util.Set;

public class Task172 {
    public static void main(String[] args) {
        System.out.println(countDistinctSubstrings("abcabcabc")); // 3
        System.out.println(countDistinctSubstrings("leetcodeleetcode")); // 2
        System.out.println(countDistinctSubstrings("aaaa")); // 3
        System.out.println(countDistinctSubstrings("ababab")); // 3
        System.out.println(countDistinctSubstrings("abcd")); // 0
    }

    public static int countDistinctSubstrings(String text) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < text.length(); i++) {
            for (int len = 2; i + len <= text.length(); len += 2) {
                String substr = text.substring(i, i + len);
                int halfLen = len / 2;
                if (substr.substring(0, halfLen).equals(substr.substring(halfLen))) {
                    seen.add(substr);
                }
            }
        }
        return seen.size();
    }
}