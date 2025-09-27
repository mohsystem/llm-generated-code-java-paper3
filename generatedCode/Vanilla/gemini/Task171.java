package Vanilla.gemini;
import java.util.Arrays;

class Task171 {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);

        int j = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && nums[i] > 2L * nums[j]) {
                j++;
            }
            count += j - (mid + 1);
        }

        Arrays.sort(nums, left, right + 1); // You can use merge sort here for O(n log n)
        return count;
    }

    public static void main(String[] args) {
        Task171 task171 = new Task171();
        int[] nums1 = {1, 3, 2, 3, 1};
        int result1 = task171.reversePairs(nums1);
        System.out.println("Test case 1: " + result1); // Output: 2

        int[] nums2 = {2, 4, 3, 5, 1};
        int result2 = task171.reversePairs(nums2);
        System.out.println("Test case 2: " + result2); // Output: 3

        int[] nums3 = {};
        int result3 = task171.reversePairs(nums3);
        System.out.println("Test case 3: " + result3); // Output: 0

        int[] nums4 = {1};
        int result4 = task171.reversePairs(nums4);
        System.out.println("Test case 4: " + result4); // Output: 0


        int[] nums5 = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        int result5 = task171.reversePairs(nums5);
        System.out.println("Test case 5: " + result5); // Output: 1
    }
}