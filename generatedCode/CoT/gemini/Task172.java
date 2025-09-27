package CoT.gemini;
import java.util.HashSet;
import java.util.Set;

public class Task172 {
    public int distinctConcatenatedStrings(String text) {
        Set<String> substrings = new HashSet<>();
        int n = text.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String sub = text.substring(i, j);
                int len = sub.length();
                if (len % 2 == 0) {
                    String a = sub.substring(0, len / 2);
                    String b = sub.substring(len / 2);
                    if (a.equals(b)) {
                        substrings.add(sub);
                    }
                }
            }
        }
        return substrings.size();
    }

    public static void main(String[] args) {
        Task172 task172 = new Task172();
        System.out.println(task172.distinctConcatenatedStrings("abcabcabc")); // 3
        System.out.println(task172.distinctConcatenatedStrings("leetcodeleetcode")); // 2
        System.out.println(task172.distinctConcatenatedStrings("aaaa")); // 2
        System.out.println(task172.distinctConcatenatedStrings("abc")); // 0
        System.out.println(task172.distinctConcatenatedStrings("abababab")); //3

    }
}