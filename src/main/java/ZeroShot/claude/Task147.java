package ZeroShot.claude;

public class Task147 {
    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1 || k > nums.length) {
            return -1;
        }
        
        // Sort array in descending order
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] < nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        
        // Return kth element (1-based index)
        return nums[k - 1];
    }

    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(arr1, 2));  // Expected: 5

        // Test case 2
        int[] arr2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest(arr2, 4));  // Expected: 4

        // Test case 3
        int[] arr3 = {1};
        System.out.println(findKthLargest(arr3, 1));  // Expected: 1

        // Test case 4
        int[] arr4 = {7, 7, 7, 7, 7};
        System.out.println(findKthLargest(arr4, 3));  // Expected: 7

        // Test case 5
        int[] arr5 = {9, 8, 7, 6, 5};
        System.out.println(findKthLargest(arr5, 1));  // Expected: 9
    }
}
