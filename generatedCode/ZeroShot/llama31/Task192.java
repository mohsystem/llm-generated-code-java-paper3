package ZeroShot.llama31;
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
        int[][] testCases = {
            {1, 1, 2},
            {0, 1},
            {1, 2, 3}
        };
        for (int[] testCase : testCases) {
            System.out.println(task.xorGame(testCase));
        }
    }
}