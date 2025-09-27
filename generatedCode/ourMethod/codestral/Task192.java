package ourMethod.codestral;
public class Task192 {
    public boolean canWinNim(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor != 0;
    }

    public static void main(String[] args) {
        Task192 solution = new Task192();
        System.out.println(solution.canWinNim(new int[]{1, 1, 2})); // false
        System.out.println(solution.canWinNim(new int[]{0, 1})); // true
        System.out.println(solution.canWinNim(new int[]{1, 2, 3})); // true
    }
}