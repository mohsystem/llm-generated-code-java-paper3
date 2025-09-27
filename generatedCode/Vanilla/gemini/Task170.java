package Vanilla.gemini;
import java.util.Arrays;

class Task170 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sums = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            sums[i + 1] = sums[i] + nums[i];
        }
        return mergeSortAndCount(sums, 0, n + 1, lower, upper);
    }

    private int mergeSortAndCount(long[] sums, int start, int end, int lower, int upper) {
        if (end - start <= 1) return 0;
        int mid = (start + end) / 2;
        int count = mergeSortAndCount(sums, start, mid, lower, upper) + 
                    mergeSortAndCount(sums, mid, end, lower, upper);
        int j = mid, k = mid, t = mid;
        long[] cache = new long[end - start];
        for (int i = start, r = 0; i < mid; ++i, ++r) {
            while (k < end && sums[k] - sums[i] < lower) k++;
            while (j < end && sums[j] - sums[i] <= upper) j++;
            while (t < end && sums[t] < sums[i]) cache[r++] = sums[t++];
            cache[r] = sums[i];
            count += j - k;
        }
        System.arraycopy(cache, 0, sums, start, t - start);
        return count;
    }

    public static void main(String[] args) {
        Task170 task = new Task170();
        int[][] nums = {{-2, 5, -1}, {0}, {1, 2, 3, 4, 5, 6, 7}, {0, 0}, {-2147483647, 0, -2147483647, 2147483647}};
        int[] lower = {-2, 0, 3, 0, -564,};
        int[] upper = {2, 0, 6, 0, 3864};

        for (int i = 0; i < nums.length; i++) {
            System.out.println(task.countRangeSum(nums[i], lower[i], upper[i]));
        }

    }
}