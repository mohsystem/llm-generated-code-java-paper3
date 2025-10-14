package Vanilla.openai;
import java.util.*;

class Task161 {

    static int knapsack(int W, int[] wt, int[] val, int n) {
        int[][] K = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i - 1] <= w)
                    K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }
        return K[n][W];
    }

    public static void main(String[] args) {
        int[] weights1 = {10, 20, 30};
        int[] values1 = {60, 100, 120};
        System.out.println(knapsack(50, weights1, values1, 3)); // Output: 220

        int[] weights2 = {1, 2, 3};
        int[] values2 = {10, 15, 40};
        System.out.println(knapsack(6, weights2, values2, 3)); // Output: 65

        int[] weights3 = {5, 4, 6, 3};
        int[] values3 = {10, 40, 30, 50};
        System.out.println(knapsack(10, weights3, values3, 4)); // Output: 90

        int[] weights4 = {1, 3, 4, 5};
        int[] values4 = {1, 4, 5, 7};
        System.out.println(knapsack(7, weights4, values4, 4)); // Output: 9

        int[] weights5 = {2, 3, 4, 5};
        int[] values5 = {3, 4, 5, 6};
        System.out.println(knapsack(5, weights5, values5, 4)); // Output: 7
    }
}