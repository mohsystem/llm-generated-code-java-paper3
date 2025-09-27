package Vanilla.gpt4o;
import java.util.*;

public class Task170 {

    public static int countRangeSum(int[] nums, int lower, int upper) {
        return countWhileMergeSort(nums, 0, nums.length, lower, upper);
    }

    private static int countWhileMergeSort(int[] nums, int start, int end, int lower, int upper) {
        if (end - start <= 1) return 0;
        int mid = (start + end) / 2;
        int count = countWhileMergeSort(nums, start, mid, lower, upper) 
                  + countWhileMergeSort(nums, mid, end, lower, upper);
        long[] cache = new long[end - start];
        long sum = 0, j = mid, k = mid, t = mid;
        for (int i = start, r = 0; i < mid; ++i, sum += nums[i]) {
            while (j < end && sum + nums[j] < lower) j++;
            while (k < end && sum + nums[k] <= upper) k++;
            while (t < end && nums[t] < sum) cache[r++] = nums[t++];
            cache[r++] = sum;
            count += k - j;
        }
        System.arraycopy(cache, 0, nums, start, t - start);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countRangeSum(new int[]{-2, 5, -1}, -2, 2)); // Output: 3
        System.out.println(countRangeSum(new int[]{0}, 0, 0)); // Output: 1
        System.out.println(countRangeSum(new int[]{1, -1, 1}, 0, 2)); // Output: 4
        System.out.println(countRangeSum(new int[]{-1, -1, 1}, -2, -1)); // Output: 3
        System.out.println(countRangeSum(new int[]{3, 3, -2, 5, 1}, 2, 4)); // Output: 3
    }
}