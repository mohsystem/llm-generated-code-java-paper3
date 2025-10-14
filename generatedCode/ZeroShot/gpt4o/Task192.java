package ZeroShot.openai;
public class Task192 {
    public boolean xorGame(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor == 0 || nums.length % 2 == 0;
    }

    public static void main(String[] args) {
        Task192 task = new Task192();
        System.out.println(task.xorGame(new int[]{1, 1, 2})); // false
        System.out.println(task.xorGame(new int[]{0, 1}));   // true
        System.out.println(task.xorGame(new int[]{1, 2, 3})); // true
        System.out.println(task.xorGame(new int[]{4, 1, 5, 7})); // true
        System.out.println(task.xorGame(new int[]{7, 7, 7, 7})); // false
    }
}