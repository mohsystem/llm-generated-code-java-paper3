package ZeroShot.gemini;
import java.util.*;

public class Task179 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // Remove elements outside the current window
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            // Remove smaller elements from the deque
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offer(i);

            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peek()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Task179 task179 = new Task179();

        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        System.out.println(Arrays.toString(task179.maxSlidingWindow(nums1, k1))); // Output: [3, 3, 5, 5, 6, 7]

        int[] nums2 = {1};
        int k2 = 1;
        System.out.println(Arrays.toString(task179.maxSlidingWindow(nums2, k2))); // Output: [1]

        int[] nums3 = {1, -1};
        int k3 = 1;
        System.out.println(Arrays.toString(task179.maxSlidingWindow(nums3, k3))); // Output: [1, -1]

        int[] nums4 = {9, 10, 9, -7, -4, -8, 2, -6};
        int k4 = 5;
        System.out.println(Arrays.toString(task179.maxSlidingWindow(nums4, k4))); // Output: [10, 10, 9, 2]

        int[] nums5 = {1, 3, 1, 2, 0, 5};
        int k5 = 3;
        System.out.println(Arrays.toString(task179.maxSlidingWindow(nums5, k5))); // Output: [3, 3, 2, 5]

    }
}