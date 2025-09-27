package ourMethod.claude;

public class Task147 {
    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        if (k <= 0 || k > nums.length) {
            throw new IllegalArgumentException("k must be between 1 and array length");
        }
        
        // Using QuickSelect algorithm for O(n) average time complexity
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }
    
    private static int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) return nums[left];
        
        int pivotIndex = partition(nums, left, right);
        
        if (pivotIndex == k) return nums[k];
        else if (pivotIndex < k) return quickSelect(nums, pivotIndex + 1, right, k);
        else return quickSelect(nums, left, pivotIndex - 1, k);
    }
    
    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;
        
        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, right);
        return i;
    }
    
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static void main(String[] args) {
        // Test cases
        int[] test1 = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(test1, 2));  // Expected: 5
        
        int[] test2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest(test2, 4));  // Expected: 4
        
        int[] test3 = {1};
        System.out.println(findKthLargest(test3, 1));  // Expected: 1
        
        int[] test4 = {1, 2, 3, 4, 5};
        System.out.println(findKthLargest(test4, 1));  // Expected: 5
        
        int[] test5 = {5, 5, 5, 5, 5};
        System.out.println(findKthLargest(test5, 2));  // Expected: 5
    }
}
