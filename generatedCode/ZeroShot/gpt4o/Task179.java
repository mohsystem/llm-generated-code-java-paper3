package ZeroShot.openai;
import java.util.*;

public class Task179 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int ri = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // Remove indices that are out of bounds
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            // Remove elements that are not useful
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            if (i >= k - 1) {
                result[ri++] = nums[deque.peek()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Task179 task = new Task179();
        System.out.println(Arrays.toString(task.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(task.maxSlidingWindow(new int[]{1}, 1)));
        System.out.println(Arrays.toString(task.maxSlidingWindow(new int[]{1, -1}, 1)));
        System.out.println(Arrays.toString(task.maxSlidingWindow(new int[]{9, 11}, 2)));
        System.out.println(Arrays.toString(task.maxSlidingWindow(new int[]{4, -2}, 2)));
    }
}