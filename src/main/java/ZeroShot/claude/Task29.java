package ZeroShot.claude;

public class Task29 {
    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
    
    public static void main(String[] args) {
        // Test cases
        int[][] testArrays = {
            {1, 2, 3},
            {3, 2, 4},
            {2, 2, 3},
            {1, 3, 4, 2},
            {5, 2, 7, 1, 8}
        };
        int[] targets = {4, 6, 4, 6, 9};
        
        for (int i = 0; i < testArrays.length; i++) {
            int[] result = twoSum(testArrays[i], targets[i]);
            System.out.printf("Test %d: [%d, %d]%n", 
                i + 1, result[0], result[1]);
        }
    }
}
