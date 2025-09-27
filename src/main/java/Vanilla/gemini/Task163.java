package Vanilla.gemini;
import java.util.Arrays;

class Task163 {
    public int longestRun(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return 1;
        }

        Arrays.sort(arr);

        int longest = 1;
        int currentRun = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] + 1) {
                currentRun++;
            } else if (arr[i] != arr[i - 1]) {
                longest = Math.max(longest, currentRun);
                currentRun = 1;
            }
        }
        longest = Math.max(longest, currentRun);
        return longest;
    }

    public static void main(String[] args) {
        Task163 task = new Task163();
        System.out.println(task.longestRun(new int[]{1, 2, 3, 5, 6, 7, 8, 9})); // 5
        System.out.println(task.longestRun(new int[]{1, 2, 3, 10, 11, 15})); // 3
        System.out.println(task.longestRun(new int[]{5, 4, 2, 1})); // 2
        System.out.println(task.longestRun(new int[]{3, 5, 7, 10, 15})); // 1
        System.out.println(task.longestRun(new int[]{1, 2, 3, 4, 5})); //5
    }
}