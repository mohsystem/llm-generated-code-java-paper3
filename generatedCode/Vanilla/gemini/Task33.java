package Vanilla.gemini;
import java.util.Arrays;

class Task33 {
    public static int queueTime(int[] customers, int n) {
        if (customers == null || customers.length == 0) {
            return 0;
        }
        if (n <= 0) {
            return -1; // Or throw an exception
        }

        int[] tills = new int[n];
        for (int customer : customers) {
            int minTill = 0;
            for (int i = 1; i < n; i++) {
                if (tills[i] < tills[minTill]) {
                    minTill = i;
                }
            }
            tills[minTill] += customer;
        }

        int maxTime = 0;
        for (int time : tills) {
            if (time > maxTime) {
                maxTime = time;
            }
        }
        return maxTime;
    }

    public static void main(String[] args) {
        System.out.println(queueTime(new int[]{5, 3, 4}, 1)); // 12
        System.out.println(queueTime(new int[]{10, 2, 3, 3}, 2)); // 10
        System.out.println(queueTime(new int[]{2, 3, 10}, 2)); // 12
        System.out.println(queueTime(new int[]{}, 1)); // 0
        System.out.println(queueTime(new int[]{1, 2, 3, 4, 5}, 3)); // 6
    }
}