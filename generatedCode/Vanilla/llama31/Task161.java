package Vanilla.llama31;
public class Task161 {
    public static int knapSack(int W, int[] wt, int[] val, int n) {
        // Base Case
        if (n == 0 || W == 0)
            return 0;

        // If weight of the nth item is more than Knapsack capacity W,
        // then this item cannot be included in the optimal solution
        if (wt[n - 1] > W)
            return knapSack(W, wt, val, n - 1);

        // Return the maximum of two cases:
        // (1) nth item included
        // (2) not included
        return Math.max(val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1), knapSack(W, wt, val, n - 1));
    }

    public static void main(String[] args) {
        int[] profit = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int W = 50;
        int n = profit.length;
        System.out.println(knapSack(W, weight, profit, n));

        // Test cases
        int[] profit1 = {10, 20, 30};
        int[] weight1 = {1, 2, 3};
        int W1 = 4;
        int n1 = profit1.length;
        System.out.println(knapSack(W1, weight1, profit1, n1));

        int[] profit2 = {5, 10, 15};
        int[] weight2 = {2, 3, 4};
        int W2 = 6;
        int n2 = profit2.length;
        System.out.println(knapSack(W2, weight2, profit2, n2));

        int[] profit3 = {20, 30, 40};
        int[] weight3 = {5, 6, 7};
        int W3 = 10;
        int n3 = profit3.length;
        System.out.println(knapSack(W3, weight3, profit3, n3));

        int[] profit4 = {40, 50, 60};
        int[] weight4 = {8, 9, 10};
        int W4 = 15;
        int n4 = profit4.length;
        System.out.println(knapSack(W4, weight4, profit4, n4));
    }
}