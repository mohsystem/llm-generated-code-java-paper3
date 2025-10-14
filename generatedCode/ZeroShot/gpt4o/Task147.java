package ZeroShot.openai;
import java.util.PriorityQueue;

public class Task147 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        Task147 task = new Task147();
        System.out.println(task.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2)); // 5
        System.out.println(task.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4)); // 4
        System.out.println(task.findKthLargest(new int[]{1, 2, 3, 4, 5, 6}, 1)); // 6
        System.out.println(task.findKthLargest(new int[]{7, 10, 4, 3, 20, 15}, 3)); // 10
        System.out.println(task.findKthLargest(new int[]{-1, -2, 0, 2}, 2)); // 0
    }
}