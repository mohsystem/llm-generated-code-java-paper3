package CoT.llama31;
public class Task179 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] result = new int[n - k + 1];
        java.util.Deque<Integer> deque = new java.util.LinkedList<>();

        for (int i = 0; i < n; i++) {
            // Remove elements from the back of the deque that are out of the current window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            // Remove elements from the front of the deque that are smaller than the current element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            // Add the maximum element of the current window to the result
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Test cases
        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int k1 = 3;
        int[] result1 = maxSlidingWindow(nums1, k1);
        for (int num : result1) {
            System.out.print(num + " ");
        }
        System.out.println();

        int[] nums2 = {1};
        int k2 = 1;
        int[] result2 = maxSlidingWindow(nums2, k2);
        for (int num : result2) {
            System.out.print(num + " ");
        }
        System.out.println();

        int[] nums3 = {1, 2, 3, 4, 5};
        int k3 = 2;
        int[] result3 = maxSlidingWindow(nums3, k3);
        for (int num : result3) {
            System.out.print(num + " ");
        }
        System.out.println();

        int[] nums4 = {5, 4, 3, 2, 1};
        int k4 = 2;
        int[] result4 = maxSlidingWindow(nums4, k4);
        for (int num : result4) {
            System.out.print(num + " ");
        }
        System.out.println();

        int[] nums5 = {1, 1, 1, 1, 1};
        int k5 = 3;
        int[] result5 = maxSlidingWindow(nums5, k5);
        for (int num : result5) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}