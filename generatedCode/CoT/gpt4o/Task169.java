package CoT.openai;
import java.util.ArrayList;
import java.util.List;

public class Task169 {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;

        Integer[] counts = new Integer[nums.length];
        int[] sorted = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            counts[i] = insert(sorted, nums[i], i, nums.length - 1 - i);
        }

        for (Integer count : counts) {
            result.add(count);
        }
        return result;
    }

    private int insert(int[] sorted, int num, int end, int len) {
        int low = 0, high = len;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (sorted[mid] >= num) high = mid;
            else low = mid + 1;
        }
        for (int j = len; j > low; j--) {
            sorted[j] = sorted[j - 1];
        }
        sorted[low] = num;
        return low;
    }

    public static void main(String[] args) {
        Task169 task = new Task169();
        int[][] testCases = {{5, 2, 6, 1}, {-1}, {-1, -1}, {2, 0, 1}, {7, 6, 5, 4, 3, 2, 1}};
        for (int[] testCase : testCases) {
            System.out.println(task.countSmaller(testCase));
        }
    }
}