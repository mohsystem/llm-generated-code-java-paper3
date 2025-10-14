package ourMethodv2.gpt4o;
import java.util.*;

public class Task179 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            // Remove indices that are out of the current window
            if (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            // Remove elements smaller than the current element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            // Start to add results to the output array
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peek()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums1, k1))); // [3, 3, 5, 5, 6, 7]

        int[] nums2 = {1};
        int k2 = 1;
        System.out.println(Arrays.toString(maxSlidingWindow(nums2, k2))); // [1]

        int[] nums3 = {9, 11};
        int k3 = 2;
        System.out.println(Arrays.toString(maxSlidingWindow(nums3, k3))); // [11]

        int[] nums4 = {4, -2};
        int k4 = 2;
        System.out.println(Arrays.toString(maxSlidingWindow(nums4, k4))); // [4]

        int[] nums5 = {-7, -8, 7, 5, 7, 1, 6, 0};
        int k5 = 4;
        System.out.println(Arrays.toString(maxSlidingWindow(nums5, k5))); // [7, 7, 7, 7, 7]
    }
}