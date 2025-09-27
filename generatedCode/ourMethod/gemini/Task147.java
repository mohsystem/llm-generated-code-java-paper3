package ourMethod.gemini;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

class Task147 {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
            throw new IllegalArgumentException("Invalid input");
        }
        // Using a min-heap to store the k largest elements seen so far
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the smallest element if heap size exceeds k
            }
        }

        return minHeap.peek();
    }


    public static void main(String[] args) {
        Task147 task147 = new Task147();
        int[] test1 = {3, 2, 1, 5, 6, 4};
        System.out.println(task147.findKthLargest(test1, 2)); // Expected 5

        int[] test2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(task147.findKthLargest(test2, 4)); // Expected 4

        int[] test3 = {1};
        System.out.println(task147.findKthLargest(test3, 1)); // Expected 1

        int[] test4 = {1, 2};
        System.out.println(task147.findKthLargest(test4, 1)); // Expected 2

        int[] test5 = {4, 2, 7, 1, 9, 5};
        System.out.println(task147.findKthLargest(test5, 3)); // Expected 5

    }
}