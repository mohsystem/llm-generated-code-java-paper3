package CoT.gemini;
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
        int count = mergeSortAndCount(sums, start, mid, lower, upper) 
                   + mergeSortAndCount(sums, mid, end, lower, upper);
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
        Task170 task170 = new Task170();
        int[] nums1 = {-2, 5, -1};
        int lower1 = -2, upper1 = 2;
        System.out.println(task170.countRangeSum(nums1, lower1, upper1)); // Output: 3

        int[] nums2 = {0};
        int lower2 = 0, upper2 = 0;
        System.out.println(task170.countRangeSum(nums2, lower2, upper2)); // Output: 1

        int[] nums3 = {1, 2, 3, 4, 5};
        int lower3 = 3, upper3 = 6;
        System.out.println(task170.countRangeSum(nums3, lower3, upper3)); // Output: 3

        int[] nums4 = {-2147483647,0,-2147483647,2147483647};
        int lower4 = -564, upper4 = 3871;
        System.out.println(task170.countRangeSum(nums4, lower4, upper4)); // Output: 3

        int[] nums5 = {2147483647,-2147483648,-1,0};
        int lower5 = -1, upper5 = 0;
        System.out.println(task170.countRangeSum(nums5, lower5, upper5)); // Output: 3

    }
}