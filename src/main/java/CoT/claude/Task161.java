package CoT.claude;

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
        int[] weights3 = {2, 5, 1, 3, 4};
        int[] values3 = {6, 9, 1, 4, 7};
        System.out.println("Test 3: " + knapsack(8, weights3, values3)); // Expected: 20

        // Test case 4
        int[] weights4 = {1, 3, 4, 5};
        int[] values4 = {1, 4, 5, 7};
        System.out.println("Test 4: " + knapsack(7, weights4, values4)); // Expected: 9

        // Test case 5
        int[] weights5 = {};
        int[] values5 = {};
        System.out.println("Test 5: " + knapsack(5, weights5, values5)); // Expected: 0
    }
}
