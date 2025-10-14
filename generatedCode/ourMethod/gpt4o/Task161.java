package ourMethod.openai;
public class Task161 {
    public static int knapsack(int capacity, int[] weights, int[] values) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {
        System.out.println(knapsack(50, new int[]{10, 20, 30}, new int[]{60, 100, 120})); // 220
        System.out.println(knapsack(10, new int[]{5, 4, 6}, new int[]{10, 40, 30})); // 40
        System.out.println(knapsack(5, new int[]{1, 2, 3}, new int[]{6, 10, 12})); // 22
        System.out.println(knapsack(0, new int[]{1, 2, 3}, new int[]{6, 10, 12})); // 0
        System.out.println(knapsack(7, new int[]{2, 3, 4, 5}, new int[]{3, 4, 5, 6})); // 9
    }
}