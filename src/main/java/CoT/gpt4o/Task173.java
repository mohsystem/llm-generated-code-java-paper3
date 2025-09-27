package CoT.gpt4o;
import java.util.HashSet;
import java.util.Set;

public class Task173 {
    public String longestDupSubstring(String s) {
        int left = 1, right = s.length();
        String result = "";
        while (left <= right) {
            int mid = left + (right - left) / 2;
            String dup = search(s, mid);
            if (dup != null) {
                result = dup;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    private String search(String s, int len) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i <= s.length() - len; i++) {
            String sub = s.substring(i, i + len);
            if (seen.contains(sub)) return sub;
            seen.add(sub);
        }
        return null;
    }

    public static void main(String[] args) {
        Task173 task = new Task173();
        System.out.println(task.longestDupSubstring("banana")); // Output: "ana"
        System.out.println(task.longestDupSubstring("abcd"));   // Output: ""
        System.out.println(task.longestDupSubstring("aabbcc")); // Output: "aa"
        System.out.println(task.longestDupSubstring("aaaa"));   // Output: "aaa"
        System.out.println(task.longestDupSubstring("abcabc")); // Output: "abc"
    }
}