package ZeroShot.codestral;
public class Task170 {
    public static int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        return countWhileMerging(sum, 0, n + 1, lower, upper);
    }

    private static int countWhileMerging(long[] sum, int start, int end, int lower, int upper) {
        if (end - start <= 1) return 0;
        int mid = (start + end) / 2;
        int count = countWhileMerging(sum, start, mid, lower, upper)
                    + countWhileMerging(sum, mid, end, lower, upper);
        int j = mid, k = mid, t = mid;
        long[] cache = new long[end - start];
        for (int i = start, r = 0; i < mid; i++, r++) {
            while (k < end && sum[k] - sum[i] < lower) k++;
            while (j < end && sum[j] - sum[i] <= upper) j++;
            while (t < end && sum[t] < sum[i]) cache[r++] = sum[t++];
            count += j - k;
        }
        System.arraycopy(sum, t, sum, start, end - t);
        //todo cannot find symbol variable r
//        System.arraycopy(cache, 0, sum, start + t - mid, r);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countRangeSum(new int[]{-2,5,-1}, -2, 2)); // Output: 3
        System.out.println(countRangeSum(new int[]{0}, 0, 0)); // Output: 1
    }
}