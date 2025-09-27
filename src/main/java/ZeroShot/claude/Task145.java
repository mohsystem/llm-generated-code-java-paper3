package ZeroShot.claude;

public class Task145 {
    public static int maxSubArraySum(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        
        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        
        return maxSoFar;
    }

    public static void main(String[] args) {
        // Test cases
        int[] test1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] test2 = {1, 2, 3, 4, 5};
        int[] test3 = {-1, -2, -3, -4};
        int[] test4 = {1};
        int[] test5 = {-2, 1};

        System.out.println("Test 1: " + maxSubArraySum(test1)); // Expected: 6
        System.out.println("Test 2: " + maxSubArraySum(test2)); // Expected: 15
        System.out.println("Test 3: " + maxSubArraySum(test3)); // Expected: -1
        System.out.println("Test 4: " + maxSubArraySum(test4)); // Expected: 1
        System.out.println("Test 5: " + maxSubArraySum(test5)); // Expected: 1
    }
}
