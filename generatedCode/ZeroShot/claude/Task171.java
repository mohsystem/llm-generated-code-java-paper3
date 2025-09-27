package ZeroShot.claude;

public class Task171 {
    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) return 0;
        
        int mid = left + (right - left) / 2;
        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
        
        // Count reverse pairs
        int j = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && nums[i] > 2L * nums[j]) {
                j++;
            }
            count += j - (mid + 1);
        }
        
        // Merge
        int[] temp = new int[right - left + 1];
        int i = left, k = mid + 1, p = 0;
        while (i <= mid && k <= right) {
            temp[p++] = nums[i] <= nums[k] ? nums[i++] : nums[k++];
        }
        while (i <= mid) temp[p++] = nums[i++];
        while (k <= right) temp[p++] = nums[k++];
        
        for (i = 0; i < temp.length; i++) {
            nums[left + i] = temp[i];
        }
        
        return count;
    }
    
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
    
    public static void main(String[] args) {
        Task171 solution = new Task171();
        
        // Test case 1
        System.out.println(solution.reversePairs(new int[]{1,3,2,3,1}));  // Expected: 2
        
        // Test case 2
        System.out.println(solution.reversePairs(new int[]{2,4,3,5,1}));  // Expected: 3
        
        // Test case 3
        System.out.println(solution.reversePairs(new int[]{1,1,1,1,1}));  // Expected: 0
        
        // Test case 4
        System.out.println(solution.reversePairs(new int[]{5,4,3,2,1}));  // Expected: 4
        
        // Test case 5
        System.out.println(solution.reversePairs(new int[]{2147483647,2147483647,2147483647}));  // Expected: 0
    }
}
