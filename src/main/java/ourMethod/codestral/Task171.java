package ourMethod.codestral;

import java.util.Arrays;

public class Task171 {
    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) return 0;
        int mid = (left + right) / 2;
        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
        for (int i = left, j = mid + 1; i <= mid; i++) {
            while (j <= right && nums[i] / 2.0 > nums[j]) j++;
            count += j - (mid + 1);
        }
        Arrays.sort(nums, left, right + 1);
        return count;
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        Task171 solution = new Task171();
        System.out.println(solution.reversePairs(new int[]{1,3,2,3,1})); // Output: 2
        System.out.println(solution.reversePairs(new int[]{2,4,3,5,1})); // Output: 3
    }
}