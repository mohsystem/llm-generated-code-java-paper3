package ourMethodv2.gpt4o;
import java.util.ArrayList;
import java.util.List;

public class Task169 {
    public List<Integer> countSmaller(int[] nums) {
        int[] result = new int[nums.length];
        List<Integer> sortedList = new ArrayList<>();
        
        for (int i = nums.length - 1; i >= 0; i--) {
            int index = findIndex(sortedList, nums[i]);
            result[i] = index;
            sortedList.add(index, nums[i]);
        }
        
        List<Integer> resultList = new ArrayList<>();
        for (int res : result) {
            resultList.add(res);
        }
        return resultList;
    }

    private int findIndex(List<Integer> sortedList, int target) {
        int low = 0, high = sortedList.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (sortedList.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    
    public static void main(String[] args) {
        Task169 task = new Task169();
        System.out.println(task.countSmaller(new int[]{5, 2, 6, 1})); // [2, 1, 1, 0]
        System.out.println(task.countSmaller(new int[]{-1})); // [0]
        System.out.println(task.countSmaller(new int[]{-1, -1})); // [0, 0]
        System.out.println(task.countSmaller(new int[]{3, 2, 2, 1})); // [3, 2, 1, 0]
        System.out.println(task.countSmaller(new int[]{0, 0, 0, 0})); // [0, 0, 0, 0]
    }
}