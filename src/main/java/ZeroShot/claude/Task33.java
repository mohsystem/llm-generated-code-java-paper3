package ZeroShot.claude;

public class Task33 {
    public static int queueTime(int[] customers, int n) {
        int[] tills = new int[n];
        for (int customer : customers) {
            tills[0] = Math.min(tills[0], tills[n-1]);
            int minTill = 0;
            for(int i = 1; i < n; i++) {
                if(tills[i] < tills[minTill]) {
                    minTill = i;
                }
            }
            tills[minTill] += customer;
        }
        
        int maxTime = tills[0];
        for(int i = 1; i < n; i++) {
            maxTime = Math.max(maxTime, tills[i]);
        }
        return maxTime;
    }

    public static void main(String[] args) {
        // Test case 1
        System.out.println(queueTime(new int[]{5,3,4}, 1)); // Expected: 12
        
        // Test case 2
        System.out.println(queueTime(new int[]{10,2,3,3}, 2)); // Expected: 10
        
        // Test case 3
        System.out.println(queueTime(new int[]{2,3,10}, 2)); // Expected: 12
        
        // Test case 4
        System.out.println(queueTime(new int[]{}, 1)); // Expected: 0
        
        // Test case 5
        System.out.println(queueTime(new int[]{1,2,3,4,5}, 100)); // Expected: 5
    }
}
