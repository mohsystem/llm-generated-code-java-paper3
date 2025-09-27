package CoT.gemini;
import java.util.Arrays;

class Task171 {
    public int reversePairs(int[] nums) {
        return mergeSortAndCount(nums, 0, nums.length - 1);
    }

    private int mergeSortAndCount(int[] nums, int low, int high) {
        if (low >= high) {
            return 0;
        }

        int mid = low + (high - low) / 2;
        int count = mergeSortAndCount(nums, low, mid) + mergeSortAndCount(nums, mid + 1, high);

        int j = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (j <= high && nums[i] > 2L * nums[j]) {
                j++;
            }
            count += j - (mid + 1);
        }

        Arrays.sort(nums, low, high + 1); // Or use merge operation for O(n log n)
        return count;
    }

    public static void main(String[] args) {
        Task171 task171 = new Task171();
        int[] test1 = {1, 3, 2, 3, 1};
        int[] test2 = {2, 4, 3, 5, 1};
        int[] test3 = {};
        int[] test4 = {1};
        int[] test5 = {Integer.MAX_VALUE, Integer.MIN_VALUE};


        System.out.println("Test case 1: " + task171.reversePairs(test1)); // Output: 2
        System.out.println("Test case 2: " + task171.reversePairs(test2)); // Output: 3
        System.out.println("Test case 3: " + task171.reversePairs(test3)); // Output: 0
        System.out.println("Test case 4: " + task171.reversePairs(test4)); // Output: 0
        System.out.println("Test case 5: " + task171.reversePairs(test5)); // Output: 1

    }
}