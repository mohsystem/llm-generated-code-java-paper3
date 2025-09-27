package Vanilla.gemini;
import java.util.HashSet;
import java.util.Set;

class Task172 {
    public int distinctEchoSubstrings(String text) {
        Set<String> distinctEchoes = new HashSet<>();
        int n = text.length();
        for (int len = 1; len <= n / 2; len++) {
            for (int i = 0; i <= n - 2 * len; i++) {
                String s1 = text.substring(i, i + len);
                String s2 = text.substring(i + len, i + 2 * len);
                if (s1.equals(s2)) {
                    distinctEchoes.add(s1 + s2);
                }
            }
        }
        return distinctEchoes.size();
    }

    public static void main(String[] args) {
        Task172 task = new Task172();
        System.out.println(task.distinctEchoSubstrings("abcabcabc")); // 3
        System.out.println(task.distinctEchoSubstrings("leetcodeleetcode")); // 2
        System.out.println(task.distinctEchoSubstrings("a")); // 0
        System.out.println(task.distinctEchoSubstrings("aa")); // 1
        System.out.println(task.distinctEchoSubstrings("aaaa")); // 2

    }
}