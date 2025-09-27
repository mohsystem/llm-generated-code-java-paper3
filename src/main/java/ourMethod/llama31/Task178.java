package ourMethod.llama31;
public class Task178 {
    public static int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                long sum = prefixSum[j + 1] - prefixSum[i];
                if (sum >= k) {
                    minLen = Math.min(minLen, j - i + 1);
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }

    public static void main(String[] args) {
        int[] nums1 = {1};
        int k1 = 1;
        System.out.println("Output: " + shortestSubarray(nums1, k1)); // Output: 1

        int[] nums2 = {1, 2};
        int k2 = 4;
        System.out.println("Output: " + shortestSubarray(nums2, k2)); // Output: -1

        int[] nums3 = {2, -1, 2};
        int k3 = 3;
        System.out.println("Output: " + shortestSubarray(nums3, k3)); // Output: 3
    }
}