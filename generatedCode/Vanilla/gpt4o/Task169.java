package Vanilla.openai;
import java.util.*;

public class Task169 {
    public List<Integer> countSmaller(int[] nums) {
        Integer[] result = new Integer[nums.length];
        List<Integer> sortedList = new ArrayList<>();
        
        for (int i = nums.length - 1; i >= 0; i--) {
            int pos = findIndex(sortedList, nums[i]);
            sortedList.add(pos, nums[i]);
            result[i] = pos;
        }
        
        return Arrays.asList(result);
    }

    private int findIndex(List<Integer> sortedList, int target) {
        int left = 0, right = sortedList.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (sortedList.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Task169 task = new Task169();
        System.out.println(task.countSmaller(new int[]{5, 2, 6, 1}));
        System.out.println(task.countSmaller(new int[]{-1}));
        System.out.println(task.countSmaller(new int[]{-1, -1}));
        System.out.println(task.countSmaller(new int[]{3, 4, 2, 7, 5}));
        System.out.println(task.countSmaller(new int[]{10, 9, 8, 7, 6}));
    }
}