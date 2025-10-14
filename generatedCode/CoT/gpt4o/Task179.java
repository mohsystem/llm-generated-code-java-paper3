package CoT.openai;
import java.util.*;

public class Task179 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int ri = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            if (i >= k - 1) {
                result[ri++] = nums[deque.peek()];
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] test1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] test2 = {1};
        int[] test3 = {9, 11};
        int[] test4 = {4, -2};
        int[] test5 = {10, 5, 2, 7, 8, 7};
        
        System.out.println(Arrays.toString(maxSlidingWindow(test1, 3)));
        System.out.println(Arrays.toString(maxSlidingWindow(test2, 1)));
        System.out.println(Arrays.toString(maxSlidingWindow(test3, 2)));
        System.out.println(Arrays.toString(maxSlidingWindow(test4, 1)));
        System.out.println(Arrays.toString(maxSlidingWindow(test5, 3)));
    }
}