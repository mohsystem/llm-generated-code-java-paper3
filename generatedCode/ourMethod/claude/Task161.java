package ourMethod.claude;

public class Task161 {
    public static int knapsack(int capacity, int[] weights, int[] values) {
        if (capacity <= 0 || weights == null || values == null || weights.length != values.length || weights.length == 0) {
            return 0;
        }
        
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (weights[i-1] <= w) {
                    dp[i][w] = Math.max(values[i-1] + dp[i-1][w-weights[i-1]], dp[i-1][w]);
                } else {
                    dp[i][w] = dp[i-1][w];
                }
            }
        }
        
        return dp[n][capacity];
    }
    
    public static void main(String[] args) {
        // Test case 1
        int[] weights1 = {2, 3, 4, 5};
        int[] values1 = {3, 4, 5, 6};
        System.out.println("Test 1: " + knapsack(10, weights1, values1)); // Expected: 13
        
        // Test case 2
        int[] weights2 = {1, 2, 3};
        int[] values2 = {6, 10, 12};
        System.out.println("Test 2: " + knapsack(5, weights2, values2)); // Expected: 22
        
        // Test case 3
        int[] weights3 = {10, 20, 30};
        int[] values3 = {60, 100, 120};
        System.out.println("Test 3: " + knapsack(50, weights3, values3)); // Expected: 220
        
        // Test case 4: Empty input
        System.out.println("Test 4: " + knapsack(10, new int[]{}, new int[]{})); // Expected: 0
        
        // Test case 5: Null input
        System.out.println("Test 5: " + knapsack(10, null, null)); // Expected: 0
    }
}
