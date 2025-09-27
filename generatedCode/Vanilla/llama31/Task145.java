package Vanilla.llama31;
public class Task145 {
    public static int maxSubArraySum(int[] arr) {
        int maxSum = arr[0];
        int maxEnding = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxEnding = Math.max(maxEnding + arr[i], arr[i]);
            maxSum = Math.max(maxSum, maxEnding);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, -8, 7, -1, 2, 3};
        int[] arr2 = {-2, -3, 4, -1, -2, 1, 5, -3};
        int[] arr3 = {1, 2, 3, 4, 5};
        int[] arr4 = {-1, -2, -3, -4, -5};
        int[] arr5 = {0, 0, 0, 0, 0};

        System.out.println(maxSubArraySum(arr1)); // Output: 7
        System.out.println(maxSubArraySum(arr2)); // Output: 7
        System.out.println(maxSubArraySum(arr3)); // Output: 15
        System.out.println(maxSubArraySum(arr4)); // Output: -1
        System.out.println(maxSubArraySum(arr5)); // Output: 0
    }
}