package ZeroShot.llama31;
import java.util.*;

public class Task170 {
    public static int countRangeSum(int[] nums, int lower, int upper) {
        long[] prefix = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        return mergeSort(prefix, 0, prefix.length - 1, lower, upper);
    }

    private static int mergeSort(long[] prefix, int start, int end, int lower, int upper) {
        if (start >= end) return 0;
        int mid = start + (end - start) / 2;
        int count = mergeSort(prefix, start, mid, lower, upper) + mergeSort(prefix, mid + 1, end, lower, upper);
        count += mergeIt(prefix, start, mid, end, lower, upper);
        return count;
    }

    private static int mergeIt(long[] prefix, int start, int mid, int end, int lower, int upper) {
        int count = 0;
        int j = mid + 1, k = mid + 1;
        for (int i = start; i <= mid; i++) {
            while (k <= end && prefix[k] - prefix[i] < lower) k++;
            while (j <= end && prefix[j] - prefix[i] <= upper) j++;
            count += j - k;
        }
        merge(prefix, start, mid, end);
        return count;
    }

    private static void merge(long[] prefix, int start, int mid, int end) {
        long[] temp = new long[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            if (prefix[i] <= prefix[j]) temp[k++] = prefix[i++];
            else temp[k++] = prefix[j++];
        }
        while (i <= mid) temp[k++] = prefix[i++];
        while (j <= end) temp[k++] = prefix[j++];
        System.arraycopy(temp, 0, prefix, start, temp.length);
    }

    public static void main(String[] args) {
        Task170 task = new Task170();
        int[] nums1 = {-2, 5, -1};
        System.out.println(task.countRangeSum(nums1, -2, 2)); // Output: 3

        int[] nums2 = {0};
        System.out.println(task.countRangeSum(nums2, 0, 0)); // Output: 1

        int[] nums3 = {-3, 6, -1};
        System.out.println(task.countRangeSum(nums3, -2, 2)); // Output: 2

        int[] nums4 = {1, 2, 3, 4, 5};
        System.out.println(task.countRangeSum(nums4, 3, 7)); // Output: 5

        int[] nums5 = {-10, 10, -10, 10};
        System.out.println(task.countRangeSum(nums5, -20, 20)); // Output: 10
    }
}