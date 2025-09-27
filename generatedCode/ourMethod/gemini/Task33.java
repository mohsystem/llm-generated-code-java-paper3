package ourMethod.gemini;
import java.util.Arrays;

public class Task33 {

    public static int queueTime(int[] customers, int n) {
        if (customers == null || customers.length == 0) {
            return 0;
        }
        if (n <= 0) {
            return -1; // Or throw an exception for invalid input
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
        for (int till : tills) {
            if (till > maxTime) {
                maxTime = till;
            }
        }
        return maxTime;
    }

    public static void main(String[] args) {
        int[] test1 = {5, 3, 4};
        System.out.println(queueTime(test1, 1)); // 12

        int[] test2 = {10, 2, 3, 3};
        System.out.println(queueTime(test2, 2)); // 10

        int[] test3 = {2, 3, 10};
        System.out.println(queueTime(test3, 2)); // 12

        int[] test4 = {};
        System.out.println(queueTime(test4, 2)); // 0

        int[] test5 = {1, 2, 3, 4, 5};
        System.out.println(queueTime(test5, 3)); // 7


    }
}