package CoT.gpt4o;
import java.util.PriorityQueue;
import java.util.Collections;

public class Task147 {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2)); // 5
        System.out.println(findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4)); // 4
        System.out.println(findKthLargest(new int[]{1, 2, 3, 4, 5}, 5)); // 1
        System.out.println(findKthLargest(new int[]{7, 10, 4, 3, 20, 15}, 3)); // 10
        System.out.println(findKthLargest(new int[]{5, 5, 5, 5, 5}, 1)); // 5
    }
}