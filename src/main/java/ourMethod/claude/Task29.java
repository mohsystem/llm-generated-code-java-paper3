package ourMethod.claude;

public class Task29 {
    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            throw new IllegalArgumentException("Input array must contain at least 2 numbers");
        }
        
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                // Use safe arithmetic to prevent integer overflow
                if (numbers[i] <= target && numbers[j] <= target) {
                    long sum = (long) numbers[i] + numbers[j];
                    if (sum == target) {
                        return new int[]{i, j};
                    }
                }
            }
        }
        return new int[]{};  // Should not reach here given problem constraints
    }

    public static void main(String[] args) {
        // Test cases
        int[][] testArrays = {
            {1, 2, 3},
            {3, 2, 4},
            {2, 7, 11, 15},
            {1234, 5678, 9012},
            {0, 0, 0}
        };
        int[] testTargets = {4, 6, 9, 14690, 0};

        for (int i = 0; i < testArrays.length; i++) {
            int[] result = twoSum(testArrays[i], testTargets[i]);
            System.out.printf("Test %d: [%d, %d]%n", 
                            i + 1, result[0], result[1]);
        }
    }
}
