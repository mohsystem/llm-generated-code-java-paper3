package Vanilla.llama31;
public class Task178 {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = prefixSum[j + 1] - prefixSum[i];
                if (sum >= k) {
                    ans = Math.min(ans, j - i + 1);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        Task178 task = new Task178();
        int[] nums1 = {1};
        int k1 = 1;
        System.out.println(task.shortestSubarray(nums1, k1)); // Output: 1

        int[] nums2 = {1, 2};
        int k2 = 4;
        System.out.println(task.shortestSubarray(nums2, k2)); // Output: -1

        int[] nums3 = {2, -1, 2};
        int k3 = 3;
        System.out.println(task.shortestSubarray(nums3, k3)); // Output: 3

        int[] nums4 = {2, 1, 1, -4, 3, 1, -1, 2};
        int k4 = 5;
        System.out.println(task.shortestSubarray(nums4, k4)); // Output: 4

        int[] nums5 = {1, 4, 2, 2, 1, 3, 1, -4, -1, 1};
        int k5 = 7;
        System.out.println(task.shortestSubarray(nums5, k5)); // Output: 3
    }
}