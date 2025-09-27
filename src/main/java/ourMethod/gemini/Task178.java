package ourMethod.gemini;
import java.util.Deque;
import java.util.LinkedList;

public class Task178 {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int minLen = Integer.MAX_VALUE;
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i <= n; i++) {
            while (!dq.isEmpty() && prefixSum[i] - prefixSum[dq.peekFirst()] >= k) {
                minLen = Math.min(minLen, i - dq.pollFirst());
            }
            while (!dq.isEmpty() && prefixSum[i] <= prefixSum[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.addLast(i);

        }


        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }

    public static void main(String[] args) {
        Task178 task178 = new Task178();
        int[] nums1 = {1};
        int k1 = 1;
        System.out.println(task178.shortestSubarray(nums1, k1)); // 1

        int[] nums2 = {1, 2};
        int k2 = 4;
        System.out.println(task178.shortestSubarray(nums2, k2)); // -1

        int[] nums3 = {2, -1, 2};
        int k3 = 3;
        System.out.println(task178.shortestSubarray(nums3, k3)); // 3

        int[] nums4 = {1, 1, 1, 1, 1, 10};
        int k4 = 11;
        System.out.println(task178.shortestSubarray(nums4, k4)); // 2


        int[] nums5 = {84,-37,32,40,95};
        int k5 = 167;
        System.out.println(task178.shortestSubarray(nums5, k5)); // 3

    }
}