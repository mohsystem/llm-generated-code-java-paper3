package CoT.llama31;
public class Task170 {
    public static int countRangeSum(int[] nums, int lower, int upper) {
        long[] sum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        return countWhileMergeSort(sum, 0, sum.length, lower, upper);
    }

    private static int countWhileMergeSort(long[] sum, int start, int end, int lower, int upper) {
        if (end - start <= 1) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        int count = countWhileMergeSort(sum, start, mid, lower, upper) +
                   countWhileMergeSort(sum, mid, end, lower, upper);
        int j = mid, k = mid, t = mid;
        long[] l = new long[end - start];
        for (int i = start, r = 0; i < mid; i++, r++) {
            while (k < end && sum[k] - sum[i] < lower) {
                k++;
            }
            while (j < end && sum[j] - sum[i] <= upper) {
                j++;
            }
            while (t < end && sum[t] < sum[i]) {
                l[r++] = sum[t++];
            }
            l[r] = sum[i];
            count += j - k;
        }
        System.arraycopy(l, 0, sum, start, t - start);
        System.arraycopy(l, t - start, sum, t, end - t);
        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {-2, 5, -1};
        int lower1 = -2;
        int upper1 = 2;
        System.out.println("Output: " + countRangeSum(nums1, lower1, upper1)); // Output: 3

        int[] nums2 = {0};
        int lower2 = 0;
        int upper2 = 0;
        System.out.println("Output: " + countRangeSum(nums2, lower2, upper2)); // Output: 1

        int[] nums3 = {1, 2, 3, 4, 5};
        int lower3 = 1;
        int upper3 = 10;
        System.out.println("Output: " + countRangeSum(nums3, lower3, upper3)); // Output: 10

        int[] nums4 = {-10, -5, 0, 5, 10};
        int lower4 = -10;
        int upper4 = 10;
        System.out.println("Output: " + countRangeSum(nums4, lower4, upper4)); // Output: 15

        int[] nums5 = {0, 0, 0, 0};
        int lower5 = 0;
        int upper5 = 0;
        System.out.println("Output: " + countRangeSum(nums5, lower5, upper5)); // Output: 10
    }
}