package ZeroShot.gemini;
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
        System.out.println(task193.xorGame(new int[]{1, 1, 2})); // false
        System.out.println(task193.xorGame(new int[]{0, 1})); // true
        System.out.println(task193.xorGame(new int[]{1, 2, 3})); // true
        System.out.println(task193.xorGame(new int[]{1, 1})); // true
        System.out.println(task193.xorGame(new int[]{0})); // true


    }
}