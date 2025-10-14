package ourMethod.claude;

import java.util.Arrays;

public class Task171 {
    public static int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        
        int n = nums.length;
        if (n > 50000) {
            return 0;
        }
        
        int[] temp = new int[n];
        return mergeSort(nums, temp, 0, n - 1);
    }
    
    private static int mergeSort(int[] nums, int[] temp, int left, int right) {
        if (left >= right) {
            return 0;
        }
        
        int mid = left + (right - left) / 2;
        int count = mergeSort(nums, temp, left, mid) + mergeSort(nums, temp, mid + 1, right);
        
        int j = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && nums[i] > 2L * nums[j]) {
                j++;
            }
            count += j - (mid + 1);
        }
        
        merge(nums, temp, left, mid, right);
        return count;
    }
    
    private static void merge(int[] nums, int[] temp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        
        int i = left;
        int j = mid + 1;
        int k = left;
        
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                nums[k++] = temp[i++];
            } else {
                nums[k++] = temp[j++];
            }
        }
        
        while (i <= mid) {
            nums[k++] = temp[i++];
        }
        
        while (j <= right) {
            nums[k++] = temp[j++];
        }
    }
    
    public static void main(String[] args) {
        int[][] testCases = {
            {1, 3, 2, 3, 1},
            {2, 4, 3, 5, 1},
            {5, 4, 3, 2, 1},
            {1, 2, 3, 4, 5},
            {-5, -2, -1, -3, -4}
        };
        
        int[] expected = {2, 3, 4, 0, 1};
        
        for (int i = 0; i < testCases.length; i++) {
            int[] nums = Arrays.copyOf(testCases[i], testCases[i].length);
            int result = reversePairs(nums);
            System.out.println("Test " + (i + 1) + ": " + result + " (Expected: " + expected[i] + ")");
        }
    }
}
