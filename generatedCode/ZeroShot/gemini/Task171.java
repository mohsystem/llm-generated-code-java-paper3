package ZeroShot.gemini;
import java.util.Arrays;

class Task171 {
    public int reversePairs(int[] nums) {
        return mergeSortAndCount(nums, 0, nums.length - 1);
    }

    private int mergeSortAndCount(int[] nums, int low, int high) {
        if (low >= high) {
            return 0;
        }

        int mid = (low + high) / 2;
        int count = mergeSortAndCount(nums, low, mid) + mergeSortAndCount(nums, mid + 1, high);

        int j = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (j <= high && nums[i] > 2L * nums[j]) {
                j++;
            }
            count += j - (mid + 1);
        }

        Arrays.sort(nums, low, high + 1); // Or use merge operation for O(n log n) overall

        return count;
    }

    public static void main(String[] args) {
        Task171 task = new Task171();
        int[] nums1 = {1, 3, 2, 3, 1};
        int[] nums2 = {2, 4, 3, 5, 1};
        int[] nums3 = {1};
        int[] nums4 = {1, 2, 3, 4, 5};
        int[] nums5 = {5, 4, 3, 2, 1};

        System.out.println(task.reversePairs(nums1)); // Output: 2
        System.out.println(task.reversePairs(nums2)); // Output: 3
        System.out.println(task.reversePairs(nums3)); // Output: 0
        System.out.println(task.reversePairs(nums4)); // Output: 0
        System.out.println(task.reversePairs(nums5)); // Output: 10
    }
}