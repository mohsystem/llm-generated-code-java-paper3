package CoT.gpt4o;
public class Task170 {

    public static int countRangeSum(int[] nums, int lower, int upper) {
        return countRangeSumRecursive(nums, 0, nums.length, lower, upper);
    }

    private static int countRangeSumRecursive(int[] nums, int start, int end, int lower, int upper) {
        if (end - start <= 1) {
            return 0;
        }
        int mid = (start + end) / 2;
        int count = countRangeSumRecursive(nums, start, mid, lower, upper)
                  + countRangeSumRecursive(nums, mid, end, lower, upper);

        long[] prefixSum = new long[end - start + 1];
        prefixSum[0] = 0;
        for (int i = start; i < end; i++) {
            prefixSum[i - start + 1] = prefixSum[i - start] + nums[i];
        }

        int left = mid - start, right = mid - start;
        for (int leftStart = 0; leftStart < mid - start; leftStart++) {
            while (left < end - start && prefixSum[left] - prefixSum[leftStart] < lower) left++;
            while (right < end - start && prefixSum[right] - prefixSum[leftStart] <= upper) right++;
            count += right - left;
        }

        merge(prefixSum, 0, mid - start, end - start);

        return count;
    }

    private static void merge(long[] arr, int start, int mid, int end) {
        long[] temp = new long[end - start];
        int i = start, j = mid, k = 0;
        while (i < mid && j < end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i < mid) temp[k++] = arr[i++];
        while (j < end) temp[k++] = arr[j++];
        System.arraycopy(temp, 0, arr, start, end - start);
    }

    public static void main(String[] args) {
        System.out.println(countRangeSum(new int[]{-2, 5, -1}, -2, 2)); // 3
        System.out.println(countRangeSum(new int[]{0}, 0, 0)); // 1
        System.out.println(countRangeSum(new int[]{1, -1}, -1, 1)); // 3
        System.out.println(countRangeSum(new int[]{1, 2, 3, 4}, 3, 8)); // 6
        System.out.println(countRangeSum(new int[]{0, 0, 0, 0, 0}, 0, 0)); // 15
    }
}