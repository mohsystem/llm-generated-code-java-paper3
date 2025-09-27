package Vanilla.claude;

import java.util.*;

class Task169 {
    public int[] countSmaller(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] indices = new int[n];
        for(int i = 0; i < n; i++) {
            indices[i] = i;
        }
        
        mergeSort(nums, indices, 0, n-1, result);
        return result;
    }
    
    private void mergeSort(int[] nums, int[] indices, int start, int end, int[] result) {
        if(start >= end) return;
        
        int mid = start + (end - start)/2;
        mergeSort(nums, indices, start, mid, result);
        mergeSort(nums, indices, mid+1, end, result);
        
        merge(nums, indices, start, end, mid, result);
    }
    
    private void merge(int[] nums, int[] indices, int start, int end, int mid, int[] result) {
        int leftLen = mid - start + 1;
        int rightLen = end - mid;
        
        int[] leftIndices = new int[leftLen];
        int[] rightIndices = new int[rightLen];
        
        for(int i = 0; i < leftLen; i++) {
            leftIndices[i] = indices[start + i];
        }
        for(int i = 0; i < rightLen; i++) {
            rightIndices[i] = indices[mid + 1 + i];
        }
        
        int i = 0, j = 0, k = start;
        int rightCount = 0;
        
        while(i < leftLen && j < rightLen) {
            if(nums[leftIndices[i]] <= nums[rightIndices[j]]) {
                result[leftIndices[i]] += rightCount;
                indices[k++] = leftIndices[i++];
            } else {
                rightCount++;
                indices[k++] = rightIndices[j++];
            }
        }
        
        while(i < leftLen) {
            result[leftIndices[i]] += rightCount;
            indices[k++] = leftIndices[i++];
        }
        
        while(j < rightLen) {
            indices[k++] = rightIndices[j++];
        }
    }

    public static void main(String[] args) {
        Task169 sol = new Task169();
        
        // Test case 1
        System.out.println(Arrays.toString(sol.countSmaller(new int[]{5,2,6,1})));  // [2,1,1,0]
        
        // Test case 2
        System.out.println(Arrays.toString(sol.countSmaller(new int[]{-1})));  // [0]
        
        // Test case 3
        System.out.println(Arrays.toString(sol.countSmaller(new int[]{-1,-1})));  // [0,0]
        
        // Test case 4
        System.out.println(Arrays.toString(sol.countSmaller(new int[]{1,2,3,4})));  // [0,0,0,0]
        
        // Test case 5
        System.out.println(Arrays.toString(sol.countSmaller(new int[]{4,3,2,1})));  // [3,2,1,0]
    }
}
