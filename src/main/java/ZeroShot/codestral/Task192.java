package ZeroShot.codestral;
public class Task192 {
    public static boolean xorGame(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return (xor == 0 || nums.length % 2 == 0);
    }

    public static void main(String[] args) {
        System.out.println(xorGame(new int[]{1,1,2})); // false
        System.out.println(xorGame(new int[]{0,1})); // true
        System.out.println(xorGame(new int[]{1,2,3})); // true
    }
}