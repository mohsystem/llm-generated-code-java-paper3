package ZeroShot.codestral;
import java.util.Deque;
import java.util.LinkedList;

public class Task179 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];

        int[] output = new int[n - k + 1];
        Deque<Integer> deq = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // remove numbers out of range k
            if (!deq.isEmpty() && deq.peek() < i - k + 1) {
                deq.poll();
            }

            // remove smaller numbers in k range as they are useless
            while (!deq.isEmpty() && nums[deq.peekLast()] < nums[i]) {
                deq.pollLast();
            }

            // q contains index... r contains content
            deq.offer(i);

            if (i >= k - 1) {
                output[i - k + 1] = nums[deq.peek()];
            }
        }

        return output;
    }

    public static void main(String[] args) {
        System.out.println(java.util.Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(java.util.Arrays.toString(maxSlidingWindow(new int[]{1}, 1)));
    }
}