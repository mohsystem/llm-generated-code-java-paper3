package Vanilla.claude;

class Task145 {
    public static int maxSubArraySum(int[] arr) {
        int maxSoFar = arr[0];
        int currMax = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            currMax = Math.max(arr[i], currMax + arr[i]);
            maxSoFar = Math.max(maxSoFar, currMax);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        // Test cases
        int[] arr1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] arr2 = {1, 2, 3, -2, 5};
        int[] arr3 = {-1, -2, -3, -4};
        int[] arr4 = {1};
        int[] arr5 = {-2, 1};
        
        System.out.println("Test case 1: " + maxSubArraySum(arr1)); // Expected output: 6
        System.out.println("Test case 2: " + maxSubArraySum(arr2)); // Expected output: 9
        System.out.println("Test case 3: " + maxSubArraySum(arr3)); // Expected output: -1
        System.out.println("Test case 4: " + maxSubArraySum(arr4)); // Expected output: 1
        System.out.println("Test case 5: " + maxSubArraySum(arr5)); // Expected output: 1
    }
}
