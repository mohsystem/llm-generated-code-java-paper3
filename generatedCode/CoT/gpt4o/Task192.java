package CoT.gpt4o;
public class Task192 {
    public static boolean xorGame(int[] nums) {
        int xorSum = 0;
        for (int num : nums) {
            xorSum ^= num;
        }
        return xorSum == 0 || nums.length % 2 == 0;
    }

    public static void main(String[] args) {
        System.out.println(xorGame(new int[]{1, 1, 2})); // false
        System.out.println(xorGame(new int[]{0, 1})); // true
        System.out.println(xorGame(new int[]{1, 2, 3})); // true
        System.out.println(xorGame(new int[]{4, 4, 4, 4})); // true
        System.out.println(xorGame(new int[]{5})); // false
    }
}