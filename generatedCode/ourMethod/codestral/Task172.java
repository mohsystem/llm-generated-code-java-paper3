package ourMethod.codestral;
import java.util.HashSet;
import java.util.Set;

public class Task172 {
    public int numDistinct(String text) {
        int n = text.length();
        Set<String> set = new HashSet<>();

        for (int len = 1; len <= n / 2; len++) {
            for (int i = 0; i <= n - 2 * len; i++) {
                String a = text.substring(i, i + len);
                String b = text.substring(i + len, i + 2 * len);
                if (a.equals(b)) {
                    set.add(a);
                }
            }
        }

        return set.size();
    }

    public static void main(String[] args) {
        Task172 task = new Task172();
        System.out.println(task.numDistinct("abcabcabc")); // Output: 3
        System.out.println(task.numDistinct("leetcodeleetcode")); // Output: 2
        // Add more test cases as needed
    }
}