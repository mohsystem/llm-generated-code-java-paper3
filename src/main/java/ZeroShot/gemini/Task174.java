package ZeroShot.gemini;
class Task174 {
    public String shortestPalindrome(String s) {
        int n = s.length();
        int i = 0;
        for (int j = n - 1; j >= 0; j--) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
            }
        }
        if (i == n) {
            return s;
        }
        String remaining = s.substring(i);
        String reversedRemaining = new StringBuilder(remaining).reverse().toString();
        return reversedRemaining + shortestPalindrome(s.substring(0, i)) + remaining;
    }

    public static void main(String[] args) {
        Task174 task = new Task174();
        System.out.println(task.shortestPalindrome("aacecaaa")); // aaacecaaa
        System.out.println(task.shortestPalindrome("abcd")); // dcbabcd
        System.out.println(task.shortestPalindrome("racecar")); // racecar
        System.out.println(task.shortestPalindrome("abb")); // bbabb
        System.out.println(task.shortestPalindrome("")); // 
    }
}