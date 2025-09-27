package CoT.gemini;
import java.util.*;

class Task174 {
    public String shortestPalindrome(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + reversed;
        int[] kmpTable = new int[combined.length()];

        for (int i = 1; i < combined.length(); i++) {
            int j = kmpTable[i - 1];
            while (j > 0 && combined.charAt(i) != combined.charAt(j)) {
                j = kmpTable[j - 1];
            }
            if (combined.charAt(i) == combined.charAt(j)) {
                j++;
            }
            kmpTable[i] = j;
        }

        return reversed.substring(0, reversed.length() - kmpTable[combined.length() - 1]) + s;
    }

    public static void main(String[] args) {
        Task174 task = new Task174();
        System.out.println(task.shortestPalindrome("aacecaaa")); // Expected: aaacecaaa
        System.out.println(task.shortestPalindrome("abcd")); // Expected: dcbabcd
        System.out.println(task.shortestPalindrome("racecar")); // Expected: racecar
        System.out.println(task.shortestPalindrome("")); // Expected: ""
        System.out.println(task.shortestPalindrome("a")); // Expected: a

    }
}