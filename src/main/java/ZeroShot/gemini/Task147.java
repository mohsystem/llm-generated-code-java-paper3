package ZeroShot.gemini;
import java.util.Arrays;
import java.util.PriorityQueue;

class Task147 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        Task147 task147 = new Task147();
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        System.out.println(task147.findKthLargest(nums1, k1)); // Output: 5

        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        System.out.println(task147.findKthLargest(nums2, k2)); // Output: 4

        int[] nums3 = {1};
        int k3 = 1;
        System.out.println(task147.findKthLargest(nums3, k3)); // Output: 1

        int[] nums4 = {1, 2};
        int k4 = 2;
        System.out.println(task147.findKthLargest(nums4, k4)); // Output: 1

        int[] nums5 = {5, 4, 3, 2, 1};
        int k5 = 3;
        System.out.println(task147.findKthLargest(nums5, k5)); // Output: 3


    }
}