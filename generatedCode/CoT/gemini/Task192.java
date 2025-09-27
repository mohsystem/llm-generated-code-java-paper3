package CoT.gemini;
import java.util.Arrays;

class Task192 {
    public boolean xorGame(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor == 0 || nums.length % 2 == 0;
    }

    public static void main(String[] args) {
        Task192 task192 = new Task192();
        int[] test1 = {1, 1, 2};
        int[] test2 = {0, 1};
        int[] test3 = {1, 2, 3};
        int[] test4 = {1, 1, 1, 1};
        int[] test5 = {0};

        System.out.println("Test case 1: " + task192.xorGame(test1)); // Output: false
        System.out.println("Test case 2: " + task192.xorGame(test2)); // Output: true
        System.out.println("Test case 3: " + task192.xorGame(test3)); // Output: true
        System.out.println("Test case 4: " + task192.xorGame(test4)); // Output: true
        System.out.println("Test case 5: " + task192.xorGame(test5)); // Output: true

    }
}