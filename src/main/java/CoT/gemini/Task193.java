package CoT.gemini;
import java.util.Arrays;

class Task193 {
    public boolean xorGame(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor == 0 || nums.length % 2 == 0;
    }

    public static void main(String[] args) {
        Task193 task193 = new Task193();
        int[] test1 = {1, 1, 2};
        int[] test2 = {0, 1};
        int[] test3 = {1, 2, 3};
        int[] test4 = {1, 1, 1, 1}; // Added test case
        int[] test5 = {0}; // Added test case

        System.out.println(task193.xorGame(test1)); // Output: false
        System.out.println(task193.xorGame(test2)); // Output: true
        System.out.println(task193.xorGame(test3)); // Output: true
        System.out.println(task193.xorGame(test4)); // Output: true
        System.out.println(task193.xorGame(test5)); // Output: true

    }
}