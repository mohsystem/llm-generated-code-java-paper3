package ZeroShot.codestral;
public class Task172 {
    public int repeatedSubstringPattern(String s) {
        int count = 0;
        int n = s.length();
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                String substring = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n / i; j++) {
                    sb.append(substring);
                }
                if (sb.toString().equals(s)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Task172 task = new Task172();
        System.out.println(task.repeatedSubstringPattern("abcabcabc")); // Output: 3
        System.out.println(task.repeatedSubstringPattern("leetcodeleetcode")); // Output: 2
        System.out.println(task.repeatedSubstringPattern("aaaaa")); // Output: 4
        System.out.println(task.repeatedSubstringPattern("abc")); // Output: 0
        System.out.println(task.repeatedSubstringPattern("aabaaba")); // Output: 2
    }
}