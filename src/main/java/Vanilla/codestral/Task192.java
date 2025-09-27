package Vanilla.codestral;
public class Task192 {
    public boolean canWinNim(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor != 0 && nums.length % 2 != 0;
    }

    public static void main(String[] args) {
        Task192 task = new Task192();
        System.out.println(task.canWinNim(new int[]{1, 1, 2})); // false
        System.out.println(task.canWinNim(new int[]{0, 1})); // true
        System.out.println(task.canWinNim(new int[]{1, 2, 3})); // true
        System.out.println(task.canWinNim(new int[]{4, 8, 16})); // false
        System.out.println(task.canWinNim(new int[]{5, 1, 7})); // true
    }
}