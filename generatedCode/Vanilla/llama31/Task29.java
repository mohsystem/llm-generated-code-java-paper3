package Vanilla.llama31;
public class Task29 {
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null; // This line is technically unnecessary given the problem constraints
    }

    public static void main(String[] args) {
        int[][] testCases = {
            {1, 2, 3},
            {3, 2, 4},
            {2, 7, 11, 15},
            {3, 3},
            {5, 7, 11}
        };
        int[] targets = {4, 6, 9, 6, 12};

        for (int i = 0; i < testCases.length; i++) {
            int[] result = twoSum(testCases[i], targets[i]);
            System.out.println("Indices for target " + targets[i] + ": (" + result[0] + ", " + result[1] + ")");
        }
    }
}