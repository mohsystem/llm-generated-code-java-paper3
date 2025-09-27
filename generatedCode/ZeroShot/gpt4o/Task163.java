package ZeroShot.gpt4o;
import java.util.*;

public class Task163 {
    public static int longestRun(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int maxLen = 1;
        int currentLen = 1;

        // Check for increasing run
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] + 1) {
                currentLen++;
            } else {
                currentLen = 1;
            }
            maxLen = Math.max(maxLen, currentLen);
        }

        currentLen = 1;
        // Check for decreasing run
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] - 1) {
                currentLen++;
            } else {
                currentLen = 1;
            }
            maxLen = Math.max(maxLen, currentLen);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestRun(new int[]{1, 2, 3, 10, 11, 15})); // ➞ 3
        System.out.println(longestRun(new int[]{5, 4, 2, 1}));          // ➞ 2
        System.out.println(longestRun(new int[]{3, 5, 7, 10, 15}));    // ➞ 1
        System.out.println(longestRun(new int[]{1, 2, 3, 5, 6, 7, 8, 9})); // ➞ 5
        System.out.println(longestRun(new int[]{10, 9, 8, 7, 6, 5}));  // ➞ 6
    }
}