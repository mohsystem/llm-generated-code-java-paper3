package ourMethod.gemini;
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
        Task193 task = new Task193();
        int[] test1 = {1, 1, 2};
        int[] test2 = {0, 1};
        int[] test3 = {1, 2, 3};
        int[] test4 = {1, 1};
        int[] test5 = {0};

        System.out.println(task.xorGame(test1)); // false
        System.out.println(task.xorGame(test2)); // true
        System.out.println(task.xorGame(test3)); // true
        System.out.println(task.xorGame(test4)); // false
        System.out.println(task.xorGame(test5)); // true
    }
}