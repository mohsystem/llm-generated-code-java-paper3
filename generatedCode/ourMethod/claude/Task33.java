package ourMethod.claude;

public class Task33 {
    public static int queueTime(int[] customers, int n) {
        if (customers == null || customers.length == 0) return 0;
        if (n <= 0) return 0;
        
        // Initialize array to track time at each till
        int[] tills = new int[n];
        
        // Assign customers to tills
        for (int customerTime : customers) {
            // Find till with minimum time and add new customer
            int minIndex = 0;
            for (int i = 1; i < n; i++) {
                if (tills[i] < tills[minIndex]) {
                    minIndex = i;
                }
            }
            tills[minIndex] += customerTime;
        }
        
        // Find maximum time among all tills
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
        System.out.println(queueTime(new int[]{1,2,3,4,5}, 3));  // Should return 6
    }
}
