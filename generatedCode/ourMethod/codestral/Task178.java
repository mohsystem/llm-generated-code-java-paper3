package ourMethod.codestral;
public class Task178 {
    public static int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int res = n + 1;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            while (!deque.isEmpty() && preSum[i] - preSum[deque.peekFirst()] >= k) {
                res = Math.min(res, i - deque.pollFirst());
            }
            while (!deque.isEmpty() && preSum[i] <= preSum[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        return res <= n ? res : -1;
    }

    public static void main(String[] args) {
        System.out.println(shortestSubarray(new int[]{1}, 1)); // Output: 1
        System.out.println(shortestSubarray(new int[]{1, 2}, 4)); // Output: -1
        System.out.println(shortestSubarray(new int[]{2, -1, 2}, 3)); // Output: 3
    }
}