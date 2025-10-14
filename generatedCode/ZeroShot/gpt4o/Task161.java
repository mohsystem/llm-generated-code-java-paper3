package ZeroShot.openai;
public class Task161 {
    public static int knapsack(int capacity, int[] weights, int[] values) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w],
                                        dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 2, 2};
        int[] values = {8, 4, 0, 5, 3};
        int capacity = 4;
        System.out.println(knapsack(capacity, weights, values)); // Output: 13

        weights = new int[]{1, 2, 3};
        values = new int[]{6, 10, 12};
        capacity = 5;
        System.out.println(knapsack(capacity, weights, values)); // Output: 22

        weights = new int[]{4, 5, 1};
        values = new int[]{1, 2, 3};
        capacity = 4;
        System.out.println(knapsack(capacity, weights, values)); // Output: 3

        weights = new int[]{2, 3, 4, 5};
        values = new int[]{3, 4, 5, 6};
        capacity = 5;
        System.out.println(knapsack(capacity, weights, values)); // Output: 7

        weights = new int[]{1, 3, 4, 5};
        values = new int[]{1, 4, 5, 7};
        capacity = 7;
        System.out.println(knapsack(capacity, weights, values)); // Output: 9
    }
}