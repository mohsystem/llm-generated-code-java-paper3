package Vanilla.codestral;
public class Task170 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sums = new long[nums.length + 1];
        for (int i = 0; i < nums.length; ++i)
            sums[i + 1] = sums[i] + nums[i];
        return countWhileMerging(sums, 0, sums.length, lower, upper);
    }

    private int countWhileMerging(long[] sums, int start, int end, int lower, int upper) {
        if (end - start <= 1) return 0;
        int mid = (start + end) / 2;
        int count = countWhileMerging(sums, start, mid, lower, upper)
                  + countWhileMerging(sums, mid, end, lower, upper);
        int j = mid, k = mid, t = mid;
        long[] cache = new long[end - start];
        for (int i = start, r = 0; i < mid; ++i, ++r) {
            while (k < end && sums[k] - sums[i] < lower) k++;
            while (j < end && sums[j] - sums[i] <= upper) j++;
            while (t < end && sums[t] < sums[i]) cache[r++] = sums[t++];
            count += j - k;
        }
        System.arraycopy(cache, 0, sums, start, t - start);
        return count;
    }

    public static void main(String[] args) {
        Task170 task = new Task170();
        System.out.println(task.countRangeSum(new int[]{-2,5,-1}, -2, 2)); // 3
        System.out.println(task.countRangeSum(new int[]{0}, 0, 0)); // 1
        // Add more test cases here
    }
}