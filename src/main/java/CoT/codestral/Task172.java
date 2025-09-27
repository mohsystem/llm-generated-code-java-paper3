package CoT.codestral;
import java.util.HashSet;
import java.util.Set;

public class Task172 {
    public static int repeatedSubstringPattern(String text) {
        int len = text.length();
        for (int i = 1; i <= len / 2; i++) {
            if (len % i == 0) {
                String sub = text.substring(0, i);
                int times = len / i;
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < times; j++) {
                    sb.append(sub);
                }
                if (sb.toString().equals(text)) {
                    Set<String> distinctSubstrings = new HashSet<>();
                    for (int j = 0; j < len - i + 1; j++) {
                        distinctSubstrings.add(text.substring(j, j + i));
                    }
                    return distinctSubstrings.size();
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abcabcabc")); // Output: 3
        System.out.println(repeatedSubstringPattern("leetcodeleetcode")); // Output: 2
    }
}