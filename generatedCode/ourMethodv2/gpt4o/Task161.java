package ourMethodv2.gpt4o;
import java.util.ArrayList;
import java.util.List;

class Task161 {
    static class Item {
        int weight;
        int value;

        Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static int knapsack(int capacity, List<Item> items) {
        int n = items.size();
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            int wt = items.get(i - 1).weight;
            int val = items.get(i - 1).value;
            for (int w = 0; w <= capacity; w++) {
                if (wt <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - wt] + val);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][capacity];
    }

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item(10, 60));
        items.add(new Item(20, 100));
        items.add(new Item(30, 120));
        System.out.println(knapsack(50, items));  // 220

        items.clear();
        items.add(new Item(5, 10));
        items.add(new Item(4, 40));
        items.add(new Item(6, 30));
        System.out.println(knapsack(10, items));  // 50

        items.clear();
        items.add(new Item(1, 1));
        items.add(new Item(2, 2));
        items.add(new Item(3, 3));
        System.out.println(knapsack(4, items));  // 4

        items.clear();
        items.add(new Item(1, 10));
        items.add(new Item(3, 40));
        items.add(new Item(4, 50));
        System.out.println(knapsack(5, items));  // 50

        items.clear();
        items.add(new Item(2, 3));
        items.add(new Item(2, 4));
        items.add(new Item(4, 5));
        items.add(new Item(5, 8));
        System.out.println(knapsack(5, items));  // 8
    }
}