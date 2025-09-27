package ZeroShot.gemini;
import java.util.Arrays;

class Task192 {
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
        Task192 task = new Task192();
        int[][] testCases = {
                {1, 1, 2},
                {0, 1},
                {1, 2, 3},
                {1, 1},
                {0}
        };
        boolean[] expectedOutputs = {false, true, true, false, true};

        for (int i = 0; i < testCases.length; i++) {
            boolean actualOutput = task.xorGame(testCases[i]);
            System.out.println("Test case " + (i + 1) + ": " + Arrays.toString(testCases[i]) +
                    ", Expected output: " + expectedOutputs[i] +
                    ", Actual output: " + actualOutput);
            if (actualOutput != expectedOutputs[i]) {
                System.out.println("Test case " + (i + 1) + " failed!");
            }
        }
    }
}