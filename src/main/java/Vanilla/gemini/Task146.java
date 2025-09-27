package Vanilla.gemini;
import java.util.Arrays;

class Task146 {
    public int findMissingNumber(int[] nums) {
        int n = nums.length + 1;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = Arrays.stream(nums).sum();
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        Task146 task = new Task146();
        int[] test1 = {1, 2, 4, 5};
        int[] test2 = {1, 2, 3, 4, 6};
        int[] test3 = {2, 3, 4, 5};
        int[] test4 = {1, 3, 4, 5, 6};
        int[] test5 = {1};

        System.out.println(task.findMissingNumber(test1)); // Output: 3
        System.out.println(task.findMissingNumber(test2)); // Output: 5
        System.out.println(task.findMissingNumber(test3)); // Output: 1
        System.out.println(task.findMissingNumber(test4)); // Output: 2
        System.out.println(task.findMissingNumber(test5)); // Output: 2

    }
}