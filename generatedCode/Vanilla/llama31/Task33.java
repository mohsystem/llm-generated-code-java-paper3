package Vanilla.llama31;
public class Task33 {
    public static int queueTime(int[] customers, int n) {
        if (n == 0) n = 1;
        int[] tills = new int[n];
        for (int customer : customers) {
            int idx = 0;
            for (int i = 1; i < n; i++) {
                if (tills[i] < tills[idx]) idx = i;
            }
            tills[idx] += customer;
        }
        int max = 0;
        for (int till : tills) {
            if (till > max) max = till;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(queueTime(new int[] {5, 3, 4}, 1)); // should return 12
        System.out.println(queueTime(new int[] {10, 2, 3, 3}, 2)); // should return 10
        System.out.println(queueTime(new int[] {2, 3, 10}, 2)); // should return 12
        System.out.println(queueTime(new int[] {1, 2, 3, 4}, 1)); // should return 10
        System.out.println(queueTime(new int[] {1, 2, 3, 4, 5}, 100)); // should return 5
    }
}