package ZeroShot.gemini;
import java.util.HashSet;
import java.util.Set;

class Task173 {
    public String longestDupSubstring(String s) {
        int n = s.length();
        int left = 1, right = n - 1;
        String result = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            String duplicate = findDuplicate(s, mid);
            if (!duplicate.isEmpty()) {
                result = duplicate;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private String findDuplicate(String s, int len) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i <= s.length() - len; i++) {
            String sub = s.substring(i, i + len);
            if (seen.contains(sub)) {
                return sub;
            }
            seen.add(sub);
        }
        return "";
    }

    public static void main(String[] args) {
        Task173 task173 = new Task173();
        System.out.println(task173.longestDupSubstring("banana")); // Output: ana
        System.out.println(task173.longestDupSubstring("abcd")); // Output: ""
        System.out.println(task173.longestDupSubstring("abracadabra")); // Output: abra
        System.out.println(task173.longestDupSubstring("aabaabaaba"));  // Output: aabaaba
        System.out.println(task173.longestDupSubstring("aabcaabdaab")); // Output: aabd
    }
}