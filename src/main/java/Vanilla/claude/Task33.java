package Vanilla.claude;

public class Task33 {
    public static int queueTime(int[] customers, int n) {
        int[] tills = new int[n];
        for (int customer : customers) {
            int minTillIndex = 0;
            for (int i = 0; i < n; i++) {
                if (tills[i] < tills[minTillIndex]) {
                    minTillIndex = i;
                }
            }
            tills[minTillIndex] += customer;
        }
        
        int maxTime = 0;
        for (int time : tills) {
            maxTime = Math.max(maxTime, time);
        }
        return maxTime;
    }

    public static void main(String[] args) {
        // Test case 1
        System.out.println(queueTime(new int[]{5,3,4}, 1));  // Expected: 12
        
        // Test case 2
        System.out.println(queueTime(new int[]{10,2,3,3}, 2));  // Expected: 10
        
        // Test case 3
        System.out.println(queueTime(new int[]{2,3,10}, 2));  // Expected: 12
        
        // Test case 4
        System.out.println(queueTime(new int[]{1,2,3,4,5}, 3));  // Expected: 5
        
        // Test case 5
        System.out.println(queueTime(new int[]{}, 1));  // Expected: 0
    }
}
