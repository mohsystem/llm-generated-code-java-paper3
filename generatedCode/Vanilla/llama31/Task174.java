package Vanilla.llama31;
public class Task174 {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        String new_s = s + "#" + new StringBuilder(s).reverse().toString();
        int[] position = new int[new_s.length()];
        for (int i = 1; i < position.length; i++) {
            int pre_pos = position[i - 1];
            while (pre_pos > 0 && new_s.charAt(pre_pos) != new_s.charAt(i)) {
                pre_pos = position[pre_pos - 1];
            }
            position[i] = pre_pos + ((new_s.charAt(pre_pos) == new_s.charAt(i)) ? 1 : 0);
        }
        return new StringBuilder(s.substring(position[position.length - 1])).reverse().toString() + s;
    }

    public static void main(String[] args) {
        Task174 task = new Task174();
        System.out.println(task.shortestPalindrome("aacecaaa")); // "aaacecaaa"
        System.out.println(task.shortestPalindrome("abcd")); // "dcbabcd"
        System.out.println(task.shortestPalindrome("abc")); // "cbaabc"
        System.out.println(task.shortestPalindrome("abccba")); // "abccba"
        System.out.println(task.shortestPalindrome("a")); // "a"
    }
}