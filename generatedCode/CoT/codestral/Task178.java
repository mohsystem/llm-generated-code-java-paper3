package CoT.codestral;
public class Task178 {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int shortest = Integer.MAX_VALUE;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.getFirst()] >= k) {
                shortest = Math.min(shortest, i - deque.pollFirst());
            }
            while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.getLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }

        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }

    public static void main(String[] args) {
        Task178 task = new Task178();
        System.out.println(task.shortestSubarray(new int[]{1}, 1)); // Output: 1
        System.out.println(task.shortestSubarray(new int[]{1, 2}, 4)); // Output: -1
        System.out.println(task.shortestSubarray(new int[]{2, -1, 2}, 3)); // Output: 3
    }
}