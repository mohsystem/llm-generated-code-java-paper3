package Vanilla.gemini;
import java.util.Arrays;

class Task192 {
    public boolean xorGame(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        if (xor == 0) {
            return true;
        }
        return nums.length % 2 == 0;
    }

    public static void main(String[] args) {
        Task192 solution = new Task192();
        int[] test1 = {1, 1, 2};
        int[] test2 = {0, 1};
        int[] test3 = {1, 2, 3};
        int[] test4 = {1, 1, 2, 2, 3};
        int[] test5 = {0};


        System.out.println(solution.xorGame(test1)); // Output: false
        System.out.println(solution.xorGame(test2)); // Output: true
        System.out.println(solution.xorGame(test3)); // Output: true
        System.out.println(solution.xorGame(test4)); // Output: true
        System.out.println(solution.xorGame(test5)); // Output: true
    }
}