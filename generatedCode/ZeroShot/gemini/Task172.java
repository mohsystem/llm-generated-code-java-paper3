package ZeroShot.gemini;
import java.util.HashSet;
import java.util.Set;

class Task172 {
    public int distinctEchoSubstrings(String text) {
        Set<String> distinctEchoes = new HashSet<>();
        int n = text.length();
        for (int len = 2; len <= n; len += 2) {
            for (int i = 0; i <= n - len; i++) {
                String sub = text.substring(i, i + len);
                int mid = len / 2;
                if (sub.substring(0, mid).equals(sub.substring(mid))) {
                    distinctEchoes.add(sub);
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