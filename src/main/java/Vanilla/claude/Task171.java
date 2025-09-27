package Vanilla.claude;

public class Task171 {
    public static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
    
    private static int mergeSort(int[] nums, int start, int end) {
        if (start >= end) return 0;
        
        int mid = start + (end - start) / 2;
        int count = mergeSort(nums, start, mid) + mergeSort(nums, mid + 1, end);
        
        for (int i = start, j = mid + 1; i <= mid; i++) {
            while (j <= end && nums[i] > 2L * nums[j]) j++;
            count += j - (mid + 1);
        }
        
        merge(nums, start, mid, end);
        return count;
    }
    
    private static void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        
        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) temp[k++] = nums[i++];
            else temp[k++] = nums[j++];
        }
        
        while (i <= mid) temp[k++] = nums[i++];
        while (j <= end) temp[k++] = nums[j++];
        
        for (i = 0; i < temp.length; i++) {
            nums[start + i] = temp[i];
        }
    }

    public static void main(String[] args) {
        // Test cases
        int[][] testCases = {
            {1,3,2,3,1},
            {2,4,3,5,1},
            {1,1,1,1,1},
            {5,4,3,2,1},
            {1}
        };
        
        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test case " + (i+1) + ": " + reversePairs(testCases[i]));
        }
    }
}
