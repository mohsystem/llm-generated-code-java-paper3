package ourMethod.llama31;
public class Task170 {
    public static int countRangeSum(int[] nums, int lower, int upper) {
        long[] sum = new long[nums.length + 1];
        sum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        return countRangeSumRecursive(sum, lower, upper, 0, sum.length);
    }

    private static int countRangeSumRecursive(long[] sum, int lower, int upper, int start, int end) {
        if (end - start <= 1) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        int count = countRangeSumRecursive(sum, lower, upper, start, mid) +
                   countRangeSumRecursive(sum, lower, upper, mid, end);
        int[] temp = new int[end - start];
        int tIndex = 0;
        int l = start, r = mid;
        while (l < mid && r < end) {
            if (sum[l] <= sum[r]) {
                temp[tIndex++] = (int) sum[l++];
            } else {
                temp[tIndex++] = (int) sum[r++];
            }
        }
        while (l < mid) {
            temp[tIndex++] = (int) sum[l++];
        }
        while (r < end) {
            temp[tIndex++] = (int) sum[r++];
        }
        for (int i = start; i < end; i++) {
            sum[i] = temp[i - start];
        }
        int left = start, right = start;
        int c1 = start, c2 = start;
        while (right < end) {
            while (c1 < mid && sum[c1] - sum[right] < lower) c1++;
            while (c2 < mid && sum[c2] - sum[right] <= upper) c2++;
            count += c2 - c1;
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 5, -1};
        int lower = -2;
        int upper = 2;
        System.out.println("Output: " + countRangeSum(nums, lower, upper)); // Output: 3

        nums = new int[] {0};
        lower = 0;
        upper = 0;
        System.out.println("Output: " + countRangeSum(nums, lower, upper)); // Output: 1
    }
}