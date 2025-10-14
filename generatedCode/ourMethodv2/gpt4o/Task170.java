package ourMethodv2.gpt4o;
import java.util.*;

public class Task170 {
    public static int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) return 0;
        long[] sum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        return countWhileMergeSort(sum, 0, sum.length, lower, upper);
    }

    private static int countWhileMergeSort(long[] sum, int start, int end, int lower, int upper) {
        if (end - start <= 1) return 0;
        int mid = (start + end) / 2;
        int count = countWhileMergeSort(sum, start, mid, lower, upper)
                + countWhileMergeSort(sum, mid, end, lower, upper);
        long[] cache = new long[end - start];
        int j = mid, k = mid, t = mid, r = 0;
        for (int i = start; i < mid; i++) {
            while (k < end && sum[k] - sum[i] < lower) k++;
            while (j < end && sum[j] - sum[i] <= upper) j++;
            while (t < end && sum[t] < sum[i]) cache[r++] = sum[t++];
            cache[r++] = sum[i];
            count += j - k;
        }
        System.arraycopy(cache, 0, sum, start, t - start);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countRangeSum(new int[]{-2, 5, -1}, -2, 2)); // 3
        System.out.println(countRangeSum(new int[]{0}, 0, 0)); // 1
        System.out.println(countRangeSum(new int[]{-3, 1, 2, -2, 2, -1}, -3, 3)); // 8
        System.out.println(countRangeSum(new int[]{1, 2, 3, 4}, 1, 5)); // 6
        System.out.println(countRangeSum(new int[]{-1, -1, 1, 1}, -2, 2)); // 10
    }
}