package Vanilla.gemini;
import java.util.*;
class Task179 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
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
        Task179 task = new Task179();
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        System.out.println(Arrays.toString(task.maxSlidingWindow(nums1, k1))); // Output: [3, 3, 5, 5, 6, 7]

        int[] nums2 = {1};
        int k2 = 1;
        System.out.println(Arrays.toString(task.maxSlidingWindow(nums2, k2))); // Output: [1]

        int[] nums3 = {1, -1};
        int k3 = 1;
        System.out.println(Arrays.toString(task.maxSlidingWindow(nums3, k3))); // Output: [1, -1]


        int[] nums4 = {9, 11};
        int k4 = 2;
        System.out.println(Arrays.toString(task.maxSlidingWindow(nums4, k4))); // Output: [11]

        int[] nums5 = {4, -2};
        int k5 = 2;
        System.out.println(Arrays.toString(task.maxSlidingWindow(nums5, k5))); // Output: [4]

    }
}