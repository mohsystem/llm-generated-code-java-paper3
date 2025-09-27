package ourMethod.gemini;
import java.util.ArrayList;
import java.util.List;

class Task161 {

    public static int knapsack(int capacity, List<Item> items) {
        int n = items.size();
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (items.get(i - 1).weight <= w) {
                    dp[i][w] = Math.max(items.get(i - 1).value + dp[i - 1][w - items.get(i - 1).weight], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
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
        System.out.println(knapsack(7, items2)); // Expected: 9

         List<Item> items3 = new ArrayList<>();
        items3.add(new Item(10, 1));
        items3.add(new Item(5, 50));

        System.out.println(knapsack(15, items3)); // Expected: 51

        List<Item> items4 = new ArrayList<>();
        System.out.println(knapsack(10, items4)); // Expected: 0


        List<Item> items5 = new ArrayList<>();
        items5.add(new Item(2, 1));
        items5.add(new Item(3, 2));
        items5.add(new Item(4, 5));
        items5.add(new Item(5, 6));
        System.out.println(knapsack(8, items5)); // Expected: 8

    }
}