package CoT.openai;
public class Task193 {
    public static boolean xorGame(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor == 0 || nums.length % 2 == 0;
    }

    public static void main(String[] args) {
        int[][] testCases = {
            {1, 1, 2},
            {0, 1},
            {1, 2, 3},
            {3, 5, 6, 8},
            {1, 1, 1, 1}
        };
        
        for (int[] testCase : testCases) {
            System.out.println(xorGame(testCase));
        }
    }
}