package CoT.claude;

public class Task171 {
    public static int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        return mergeSort(nums, 0, nums.length - 1);
    }
    
    private static int mergeSort(int[] nums, int start, int end) {
        if (start >= end) return 0;
        
        int mid = start + (end - start) / 2;
        int count = mergeSort(nums, start, mid) + mergeSort(nums, mid + 1, end);
        
        // Count reverse pairs
        int j = mid + 1;
        for (int i = start; i <= mid; i++) {
            while (j <= end && nums[i] > 2L * nums[j]) {
                j++;
            }
            count += j - (mid + 1);
        }
        
        merge(nums, start, mid, end);
        return count;
    }
    
    private static void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        
        while (i <= mid && j <= end) {
            temp[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) temp[k++] = nums[i++];
        while (j <= end) temp[k++] = nums[j++];
        
        System.arraycopy(temp, 0, nums, start, temp.length);
    }

    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {1, 3, 2, 3, 1};
        System.out.println(reversePairs(nums1)); // Expected: 2

        // Test case 2
        int[] nums2 = {2, 4, 3, 5, 1};
        System.out.println(reversePairs(nums2)); // Expected: 3

        // Test case 3
        int[] nums3 = {1, 1, 1, 1};
        System.out.println(reversePairs(nums3)); // Expected: 0

        // Test case 4
        int[] nums4 = {5, 4, 3, 2, 1};
        System.out.println(reversePairs(nums4)); // Expected: 4

        // Test case 5
        int[] nums5 = {2147483647, 2147483647, 2147483647};
        System.out.println(reversePairs(nums5)); // Expected: 0
    }
}
