package CoT.claude;

public class Task29 {
    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return new int[]{};
        }
        
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
            {2, 7, 11, 15},
            {3, 3},
            {1, 5, 3, 7, 2}
        };
        int[] targets = {4, 6, 9, 6, 10};
        
        for (int i = 0; i < testArrays.length; i++) {
            int[] result = twoSum(testArrays[i], targets[i]);
            System.out.print("Test case " + (i+1) + ": [");
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[j]);
                if (j < result.length - 1) System.out.print(", ");
            }
            System.out.println("]");
        }
    }
}
