package CoT.gemini;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Task179 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            // q contains index... r contains content
            q.offer(i);
            if (i >= k - 1) {
                result[ri++] = nums[q.peek()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Task179 task179 = new Task179();

        // Test cases
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        System.out.println(Arrays.toString(task179.maxSlidingWindow(nums1, k1))); // Output: [3, 3, 5, 5, 6, 7]

        int[] nums2 = {1};
        int k2 = 1;
        System.out.println(Arrays.toString(task179.maxSlidingWindow(nums2, k2))); // Output: [1]

        int[] nums3 = {1, -1};
        int k3 = 1;
        System.out.println(Arrays.toString(task179.maxSlidingWindow(nums3, k3))); // Output: [1, -1]

        int[] nums4 = {9, 11};
        int k4 = 2;
        System.out.println(Arrays.toString(task179.maxSlidingWindow(nums4, k4))); // Output: [11]


        int[] nums5 = {4, -2};
        int k5 = 2;
        System.out.println(Arrays.toString(task179.maxSlidingWindow(nums5, k5))); // Output: [4]


    }
}