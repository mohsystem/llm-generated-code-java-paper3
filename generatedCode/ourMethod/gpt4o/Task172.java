package ourMethod.openai;
import java.util.HashSet;
import java.util.Set;

public class Task172 {
    public int countDistinctTwiceConcatenatedSubstrings(String text) {
        Set<String> substrings = new HashSet<>();
        int n = text.length();
        for (int len = 1; len <= n / 2; len++) {
            for (int i = 0; i + 2 * len <= n; i++) {
                if (text.substring(i, i + len).equals(text.substring(i + len, i + 2 * len))) {
                    substrings.add(text.substring(i, i + 2 * len));
                }
            }
        }
        return substrings.size();
    }

    public static void main(String[] args) {
        Task172 task = new Task172();
        System.out.println(task.countDistinctTwiceConcatenatedSubstrings("abcabcabc")); // 3
        System.out.println(task.countDistinctTwiceConcatenatedSubstrings("leetcodeleetcode")); // 2
        System.out.println(task.countDistinctTwiceConcatenatedSubstrings("aaa")); // 1
        System.out.println(task.countDistinctTwiceConcatenatedSubstrings("ababab")); // 2
        System.out.println(task.countDistinctTwiceConcatenatedSubstrings("xyzxyzxyz")); // 3
    }
}