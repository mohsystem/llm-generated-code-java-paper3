package Vanilla.gemini;
import java.util.Arrays;

class Task193 {
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
        Task193 task = new Task193();
        int[] nums1 = {1, 1, 2};
        System.out.println(task.xorGame(nums1)); // false

        int[] nums2 = {0, 1};
        System.out.println(task.xorGame(nums2)); // true

        int[] nums3 = {1, 2, 3};
        System.out.println(task.xorGame(nums3)); // true

        int[] nums4 = {1, 1};
        System.out.println(task.xorGame(nums4)); // true

        int[] nums5 = {1, 2, 0};
        System.out.println(task.xorGame(nums5)); // true

    }
}