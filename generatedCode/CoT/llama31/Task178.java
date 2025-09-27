package CoT.llama31;
public class Task178 {
    public static int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (prefixSum[j + 1] - prefixSum[i] >= k) {
                    res = Math.min(res, j - i + 1);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1};
        int k1 = 1;
        System.out.println(shortestSubarray(nums1, k1)); // Output: 1

        int[] nums2 = {1, 2};
        int k2 = 4;
        System.out.println(shortestSubarray(nums2, k2)); // Output: -1

        int[] nums3 = {2, -1, 2};
        int k3 = 3;
        System.out.println(shortestSubarray(nums3, k3)); // Output: 3

        int[] nums4 = {1, 4, 2, 2, 1, 3, 1};
        int k4 = 7;
        System.out.println(shortestSubarray(nums4, k4)); // Output: 2

        int[] nums5 = {1, -2, 3, -1, 2};
        int k5 = 3;
        System.out.println(shortestSubarray(nums5, k5)); // Output: 3
    }
}