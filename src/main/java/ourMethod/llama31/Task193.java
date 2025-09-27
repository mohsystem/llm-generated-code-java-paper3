package ourMethod.llama31;
public class Task193 {
    public boolean xorGame(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        if (xor == 0) {
            return true;
        }
        int n = nums.length;
        if (n % 2 == 0) {
            return true;
        }
        for (int num : nums) {
            if ((xor ^ num) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Task193 task = new Task193();
        int[][] testCases = {
            {1, 1, 2},
            {0, 1},
            {1, 2, 3}
        };
        for (int[] testCase : testCases) {
            System.out.println("Input: " + java.util.Arrays.toString(testCase));
            System.out.println("Output: " + task.xorGame(testCase));
        }
    }
}