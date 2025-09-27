package ZeroShot.codestral;
public class Task178 {
    public static int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int result = n + 1;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.getFirst()] >= k) {
                result = Math.min(result, i - deque.pollFirst());
            }
            while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.getLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }
        return result > n ? -1 : result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1};
        int k1 = 1;
        System.out.println(shortestSubarray(nums1, k1));

        int[] nums2 = {1,2};
        int k2 = 4;
        System.out.println(shortestSubarray(nums2, k2));

        int[] nums3 = {2,-1,2};
        int k3 = 3;
        System.out.println(shortestSubarray(nums3, k3));
    }
}