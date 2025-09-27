package CoT.claude;

public class Task145 {
    public static int maxSubArraySum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        
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
        int[] arr1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Test 1: " + maxSubArraySum(arr1)); // Expected: 6

        int[] arr2 = {1};
        System.out.println("Test 2: " + maxSubArraySum(arr2)); // Expected: 1

        int[] arr3 = {-1, -2, -3, -4};
        System.out.println("Test 3: " + maxSubArraySum(arr3)); // Expected: -1

        int[] arr4 = {1, 2, 3, 4, 5};
        System.out.println("Test 4: " + maxSubArraySum(arr4)); // Expected: 15

        int[] arr5 = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Test 5: " + maxSubArraySum(arr5)); // Expected: 7
    }
}
