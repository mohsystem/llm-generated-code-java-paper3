package ZeroShot.claude;

class Task161 {
    static int knapSack(int capacity, int weights[], int values[], int n) {
        int dp[][] = new int[n + 1][capacity + 1];
        
        // Build table dp[][] in bottom up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0)
                    dp[i][w] = 0;
                else if (weights[i-1] <= w)
                    dp[i][w] = Math.max(values[i-1] + dp[i-1][w-weights[i-1]], dp[i-1][w]);
                else
                    dp[i][w] = dp[i-1][w];
            }
        }
        return dp[n][capacity];
    }

    public static void main(String[] args) {
        // Test Case 1
        int values1[] = {60, 100, 120};
        int weights1[] = {10, 20, 30};
        int capacity1 = 50;
        System.out.println("Test Case 1: " + knapSack(capacity1, weights1, values1, values1.length));

        // Test Case 2
        int values2[] = {10, 40, 30, 50};
        int weights2[] = {5, 4, 6, 3};
        int capacity2 = 10;
        System.out.println("Test Case 2: " + knapSack(capacity2, weights2, values2, values2.length));

        // Test Case 3
        int values3[] = {100, 200, 300};
        int weights3[] = {10, 20, 30};
        int capacity3 = 40;
        System.out.println("Test Case 3: " + knapSack(capacity3, weights3, values3, values3.length));

        // Test Case 4
        int values4[] = {5, 10, 15, 20, 25};
        int weights4[] = {2, 4, 6, 8, 10};
        int capacity4 = 20;
        System.out.println("Test Case 4: " + knapSack(capacity4, weights4, values4, values4.length));

        // Test Case 5
        int values5[] = {1, 2, 3};
        int weights5[] = {4, 5, 6};
        int capacity5 = 3;
        System.out.println("Test Case 5: " + knapSack(capacity5, weights5, values5, values5.length));
    }
}
