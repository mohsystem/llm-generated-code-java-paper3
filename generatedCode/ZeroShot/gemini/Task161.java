package ZeroShot.gemini;
import java.util.ArrayList;
import java.util.List;

class Task161 {
    public static int knapsack(int capacity, List<Item> items) {
        int n = items.size();
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            Item item = items.get(i - 1);
            for (int w = 0; w <= capacity; w++) {
                if (item.weight > w) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - item.weight] + item.value);
                }
            }
        }

        return dp[n][capacity];
    }

    static class Item {
        int weight;
        int value;

        Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        List<Item> items1 = new ArrayList<>();
        items1.add(new Item(10, 60));
        items1.add(new Item(20, 100));
        items1.add(new Item(30, 120));
        System.out.println(knapsack(50, items1)); // Expected: 220

        List<Item> items2 = new ArrayList<>();
        items2.add(new Item(1, 1));
        items2.add(new Item(3, 4));
        items2.add(new Item(4, 5));
        items2.add(new Item(5, 7));
        System.out.println(knapsack(7, items2)); // Expected: 12

        List<Item> items3 = new ArrayList<>();
        items3.add(new Item(10, 60));
        items3.add(new Item(20, 100));
        System.out.println(knapsack(10, items3)); // Expected 60
        
        List<Item> items4 = new ArrayList<>();
        System.out.println(knapsack(10, items4)); // Expected 0
        
        List<Item> items5 = new ArrayList<>();
        items5.add(new Item(10, 60));
        items5.add(new Item(20, 100));
        items5.add(new Item(30, 120));
        System.out.println(knapsack(0, items5)); // Expected 0



    }
}