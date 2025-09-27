package CoT.codestral;
import java.util.*;

public class Task179 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] r = new int[n - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!queue.isEmpty() && queue.peek() < i - k + 1) {
                queue.poll();
            }
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offer(i);
            if (i >= k - 1) {
                r[i - k + 1] = nums[queue.peek()];
            }
        }
        return r;
    }

    public static void main(String[] args) {
        Task179 t = new Task179();
        System.out.println(Arrays.toString(t.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
        System.out.println(Arrays.toString(t.maxSlidingWindow(new int[]{1}, 1)));
    }
}