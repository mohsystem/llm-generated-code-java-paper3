package ZeroShot.openai;
import java.util.*;

public class Task170 {

    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) return 0;
        long[] prefixSums = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }
        return countWhileMergeSort(prefixSums, 0, prefixSums.length, lower, upper);
    }

    private int countWhileMergeSort(long[] sums, int start, int end, int lower, int upper) {
        if (end - start <= 1) return 0;
        int mid = (start + end) / 2;
        int count = countWhileMergeSort(sums, start, mid, lower, upper) +
                    countWhileMergeSort(sums, mid, end, lower, upper);
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
        System.out.println(task.countRangeSum(new int[]{-2, 5, -1}, -2, 2)); // 3
        System.out.println(task.countRangeSum(new int[]{0}, 0, 0)); // 1
        System.out.println(task.countRangeSum(new int[]{1, 2, 3, 4}, 1, 3)); // 3
        System.out.println(task.countRangeSum(new int[]{3, 3, -1, -2}, -3, 3)); // 7
        System.out.println(task.countRangeSum(new int[]{-2, -1, 0, 1, 2}, -3, 1)); // 9
    }
}