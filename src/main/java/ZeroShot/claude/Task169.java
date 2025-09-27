package ZeroShot.claude;

import java.util.*;

class Task169 {
    public static int[] countSmaller(int[] nums) {
        int n = nums.length;
        int[] counts = new int[n];
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        mergeSort(nums, indices, counts, 0, n - 1);
        return counts;
    }
    
    private static void mergeSort(int[] nums, int[] indices, int[] counts, int start, int end) {
        if (start >= end) return;
        
        int mid = start + (end - start) / 2;
        mergeSort(nums, indices, counts, start, mid);
        mergeSort(nums, indices, counts, mid + 1, end);
        merge(nums, indices, counts, start, mid, end);
    }
    
    private static void merge(int[] nums, int[] indices, int[] counts, int start, int mid, int end) {
        int[] merged = new int[end - start + 1];
        int[] mergedIndices = new int[end - start + 1];
        int left = start, right = mid + 1, idx = 0, rightCount = 0;
        
        while (left <= mid && right <= end) {
            if (nums[indices[right]] < nums[indices[left]]) {
                rightCount++;
                mergedIndices[idx] = indices[right];
                merged[idx++] = nums[indices[right++]];
            } else {
                counts[indices[left]] += rightCount;
                mergedIndices[idx] = indices[left];
                merged[idx++] = nums[indices[left++]];
            }
        }
        
        while (left <= mid) {
            counts[indices[left]] += rightCount;
            mergedIndices[idx] = indices[left];
            merged[idx++] = nums[indices[left++]];
        }
        
        while (right <= end) {
            mergedIndices[idx] = indices[right];
            merged[idx++] = nums[indices[right++]];
        }
        
        System.arraycopy(merged, 0, nums, start, merged.length);
        System.arraycopy(mergedIndices, 0, indices, start, mergedIndices.length);
    }

    public static void main(String[] args) {
        // Test cases
        int[][] testCases = {
            {5, 2, 6, 1},
            {-1},
            {-1, -1},
            {1, 2, 3, 4},
            {4, 3, 2, 1}
        };

        for (int[] test : testCases) {
            System.out.print("Input: ");
            System.out.println(Arrays.toString(test));
            System.out.print("Output: ");
            System.out.println(Arrays.toString(countSmaller(test)));
            System.out.println();
        }
    }
}
