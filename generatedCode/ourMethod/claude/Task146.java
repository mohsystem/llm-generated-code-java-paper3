package ourMethod.claude;

public class Task146 {
    public static int findMissingNumber(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }
        
        // Length of array is n-1, where n is the expected range
        int n = arr.length + 1;
        
        // Calculate expected sum using formula: n*(n+1)/2
        // Use long to prevent integer overflow
        long expectedSum = (long)n * (n + 1) / 2;
        
        // Calculate actual sum
        long actualSum = 0;
        for (int num : arr) {
            // Validate each number is within range
            if (num <= 0 || num > n) {
                throw new IllegalArgumentException("Array elements must be between 1 and " + n);
            }
            actualSum += num;
        }
        
        // The difference is the missing number
        return (int)(expectedSum - actualSum);
    }
    
    public static void main(String[] args) {
        // Test cases
        int[][] testArrays = {
            {1, 2, 4, 5},          // Missing 3
            {1, 2, 3, 5},          // Missing 4
            {2, 3, 4, 5},          // Missing 1
            {1, 3, 4},             // Missing 2
            {1, 2, 3, 4, 6, 7, 8}  // Missing 5
        };
        
        for (int i = 0; i < testArrays.length; i++) {
            try {
                int result = findMissingNumber(testArrays[i]);
                System.out.println("Test case " + (i+1) + ": Missing number is " + result);
            } catch (Exception e) {
                System.out.println("Test case " + (i+1) + " failed: " + e.getMessage());
            }
        }
    }
}
