package ourMethod.openai;
import java.util.*;

public class Task179 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            if (!deque.isEmpty() && deque.peek() < i - k + 1) {
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
        System.out.println(Arrays.toString(task.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3))); // Output: [3,3,5,5,6,7]
        System.out.println(Arrays.toString(task.maxSlidingWindow(new int[]{1}, 1))); // Output: [1]
        System.out.println(Arrays.toString(task.maxSlidingWindow(new int[]{9, 11}, 2))); // Output: [11]
        System.out.println(Arrays.toString(task.maxSlidingWindow(new int[]{4, -2}, 2))); // Output: [4]
        System.out.println(Arrays.toString(task.maxSlidingWindow(new int[]{7, 2, 4}, 2))); // Output: [7, 4]
    }
}