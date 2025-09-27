package ourMethod.codestral;
public class Task193 {
    public boolean xorGame(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        // If the bitwise XOR of all elements is 0, Alice loses.
        if (xor == 0) {
            return false;
        }
        // If the length of the array is even, Alice loses.
        // Otherwise, Alice can always win by leaving Bob with a XOR of 0.
        return nums.length % 2 == 0 ? false : true;
    }

    public static void main(String[] args) {
        Task193 task = new Task193();
        System.out.println(task.xorGame(new int[]{1, 1, 2}));  // Output: false
        System.out.println(task.xorGame(new int[]{0, 1}));  // Output: true
        System.out.println(task.xorGame(new int[]{1, 2, 3}));  // Output: true
    }
}