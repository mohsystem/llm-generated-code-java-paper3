package ourMethod.gemini;
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
            while (j <= right && (long) nums[i] > 2 * (long) nums[j]) {
                j++;
            }
            count += j - (mid + 1);
        }

        Arrays.sort(nums, left, right + 1); // Modified to use sort for merging.
        return count;
    }

    public static void main(String[] args) {
        Task171 task171 = new Task171();
        int[][] testCases = {
                {1, 3, 2, 3, 1},
                {2, 4, 3, 5, 1},
                {},
                {5, 4, 3, 2, 1},
                {1}
        };
        for (int[] testCase : testCases) {
            System.out.println(task171.reversePairs(testCase));
        }

    }
}