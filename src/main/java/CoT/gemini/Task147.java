package CoT.gemini;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Task147 {

    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
            throw new IllegalArgumentException("Invalid input");
        }

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
        int[] test1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        System.out.println(findKthLargest(test1, k1)); // Output: 5

        int[] test2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        System.out.println(findKthLargest(test2, k2)); // Output: 4


        int[] test3 = {1};
        int k3 = 1;
        System.out.println(findKthLargest(test3, k3)); // Output: 1

        int[] test4 = {1, 2};
        int k4 = 2;
        System.out.println(findKthLargest(test4, k4)); // Output: 1

        int[] test5 = {2, 1};
        int k5 = 1;
        System.out.println(findKthLargest(test5, k5)); // Output: 2

    }
}