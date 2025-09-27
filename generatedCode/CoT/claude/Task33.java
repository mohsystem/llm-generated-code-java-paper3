package CoT.claude;

public class Task33 {
    public static int queueTime(int[] customers, int n) {
        if (customers.length == 0) return 0;
        if (n == 1) {
            int sum = 0;
            for (int time : customers) sum += time;
            return sum;
        }
        
        int[] tills = new int[n];
        for (int customer : customers) {
            int minIndex = 0;
            for (int i = 1; i < n; i++) {
                if (tills[i] < tills[minIndex]) {
                    minIndex = i;
                }
            }
            tills[minIndex] += customer;
        }
        
        int maxTime = tills[0];
        for (int i = 1; i < n; i++) {
            maxTime = Math.max(maxTime, tills[i]);
        }
        return maxTime;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(queueTime(new int[]{5,3,4}, 1));  // Should return 12
        System.out.println(queueTime(new int[]{10,2,3,3}, 2));  // Should return 10
        System.out.println(queueTime(new int[]{2,3,10}, 2));  // Should return 12
        System.out.println(queueTime(new int[]{}, 1));  // Should return 0
        System.out.println(queueTime(new int[]{1,2,3,4,5}, 3));  // Should return 5
    }
}
