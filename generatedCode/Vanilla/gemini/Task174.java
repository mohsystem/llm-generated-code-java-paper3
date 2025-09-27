package Vanilla.gemini;
class Task174 {
    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        String l = s + "#" + rev;
        int[] p = new int[l.length()];
        for (int i = 1; i < l.length(); i++) {
            int j = p[i - 1];
            while (j > 0 && l.charAt(i) != l.charAt(j)) {
                j = p[j - 1];
            }
            if (l.charAt(i) == l.charAt(j)) {
                j++;
            }
            p[i] = j;
        }
        return rev.substring(0, s.length() - p[l.length() - 1]) + s;
    }

    public static void main(String[] args) {
        Task174 task = new Task174();
        System.out.println(task.shortestPalindrome("aacecaaa")); // aaacecaaa
        System.out.println(task.shortestPalindrome("abcd")); // dcbabcd
        System.out.println(task.shortestPalindrome("abb")); // bbabb
        System.out.println(task.shortestPalindrome("")); // ""
        System.out.println(task.shortestPalindrome("a")); // a


    }
}