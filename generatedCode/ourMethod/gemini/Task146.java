package ourMethod.gemini;
import java.util.Arrays;

class Task146 {
    public int findMissingNumber(int[] nums) {
        int n = nums.length + 1;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        Task146 task = new Task146();

        // Test cases
        int[] test1 = {1, 2, 3, 4, 6};
        int missing1 = task.findMissingNumber(test1);
        System.out.println("Missing number: " + missing1); // Expected: 5

        int[] test2 = {1, 2, 4, 5, 6};
        int missing2 = task.findMissingNumber(test2);
        System.out.println("Missing number: " + missing2); // Expected: 3


        int[] test3 = {2, 3, 4, 5, 6};
        int missing3 = task.findMissingNumber(test3);
        System.out.println("Missing number: " + missing3); // Expected: 1

        int[] test4 = {1, 2, 3, 4, 5};
        int missing4 = task.findMissingNumber(test4);
        System.out.println("Missing number: " + missing4); // Expected: 6

        int[] test5 = {1};
        int missing5 = task.findMissingNumber(test5);
        System.out.println("Missing number: " + missing5); // Expected: 2

    }
}