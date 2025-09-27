package ourMethod.gpt4o;
public class Task170 {
    public static int countRangeSum(int[] nums, int lower, int upper) {
        return countRangeSumRecursive(nums, lower, upper, 0, nums.length - 1);
    }

    private static int countRangeSumRecursive(int[] nums, int lower, int upper, int start, int end) {
        if (start > end) return 0;
        if (start == end) return (nums[start] >= lower && nums[start] <= upper) ? 1 : 0;

        int mid = start + (end - start) / 2;
        int count = countRangeSumRecursive(nums, lower, upper, start, mid) 
                  + countRangeSumRecursive(nums, lower, upper, mid + 1, end);

        long[] leftSums = new long[mid - start + 1];
        leftSums[0] = nums[start];
        for (int i = start + 1; i <= mid; i++) {
            leftSums[i - start] = leftSums[i - start - 1] + nums[i];
        }

        long[] rightSums = new long[end - mid];
        rightSums[0] = nums[mid + 1];
        for (int i = mid + 2; i <= end; i++) {
            rightSums[i - mid - 1] = rightSums[i - mid - 2] + nums[i];
        }

        for (long leftSum : leftSums) {
            for (long rightSum : rightSums) {
                long sum = leftSum + rightSum;
                if (sum >= lower && sum <= upper) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countRangeSum(new int[]{-2, 5, -1}, -2, 2)); // 3
        System.out.println(countRangeSum(new int[]{0}, 0, 0));          // 1
        System.out.println(countRangeSum(new int[]{3, -1, 2, -4}, -3, 1)); // 4
        System.out.println(countRangeSum(new int[]{1, 2, 3, 4}, 0, 5)); // 3
        System.out.println(countRangeSum(new int[]{0, 0, 0, 0}, 0, 0)); // 10
    }
}