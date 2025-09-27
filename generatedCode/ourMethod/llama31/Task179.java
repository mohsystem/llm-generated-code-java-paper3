package ourMethod.llama31;
import java.util.Deque;
import java.util.LinkedList;

public class Task179 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // Remove elements from the back of the deque that are out of the current window
            while (!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
                dq.pollFirst();
            }
            // Remove elements from the front of the deque that are smaller than the current element
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            // Add the current element to the back of the deque
            dq.offerLast(i);

            // Add the maximum element of the current window to the result
            if (i >= k - 1) {
                result[i - k + 1] = nums[dq.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();

        nums = new int[] {1};
        k = 1;
        result = maxSlidingWindow(nums, k);
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}