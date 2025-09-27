package Vanilla.codestral;
public class Task174 {
    public String shortestPalindrome(String s) {
        int i = 0;
        int end = s.length() - 1;
        int j = end;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                i = 0;
                end--;
                j = end;
            }
        }
        return new StringBuilder(s.substring(end + 1)).reverse().toString() + s;
    }

    public static void main(String[] args) {
        Task174 task = new Task174();
        System.out.println(task.shortestPalindrome("aacecaaa")); // Output: "aaacecaaa"
        System.out.println(task.shortestPalindrome("abcd")); // Output: "dcbabcd"
    }
}