package CoT.gemini;
import java.util.Deque;
import java.util.LinkedList;

public class Task178 {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int minLength = Integer.MAX_VALUE;
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i <= n; i++) {
            while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.peekLast()]) {
                deque.pollLast();
            }
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peekFirst()] >= k) {
                minLength = Math.min(minLength, i - deque.pollFirst());
            }
            deque.offerLast(i);
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    public static void main(String[] args) {
        Task178 task178 = new Task178();
        int[] nums1 = {1};
        int k1 = 1;
        System.out.println(task178.shortestSubarray(nums1, k1)); // Output: 1

        int[] nums2 = {1, 2};
        int k2 = 4;
        System.out.println(task178.shortestSubarray(nums2, k2)); // Output: -1

        int[] nums3 = {2, -1, 2};
        int k3 = 3;
        System.out.println(task178.shortestSubarray(nums3, k3)); // Output: 3

        int[] nums4 = {1, 2, 3, 4, 5};
        int k4 = 10;
        System.out.println(task178.shortestSubarray(nums4, k4)); // Output: 3

        int[] nums5 = {-1, -1, 2, 3};
        int k5 = 5;
        System.out.println(task178.shortestSubarray(nums5, k5)); // Output: -1


    }
}