package CoT.codestral;
public class Task193 {
    public boolean xorGame(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        if (xor == 0) {
            return false;
        }
        int count = 0;
        for (int num : nums) {
            if ((xor ^ num) < num) {
                count++;
            }
        }
        return count % 2 == 1;
    }

    public static void main(String[] args) {
        Task193 task = new Task193();
        System.out.println(task.xorGame(new int[]{1, 1, 2})); // false
        System.out.println(task.xorGame(new int[]{0, 1})); // true
        System.out.println(task.xorGame(new int[]{1, 2, 3})); // true
    }
}