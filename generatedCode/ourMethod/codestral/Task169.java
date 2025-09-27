package ourMethod.codestral;
import java.util.*;

public class Task169 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] counts = new int[n];
        int[] sortedNums = new int[n];
        System.arraycopy(nums, 0, sortedNums, 0, n);
        Arrays.sort(sortedNums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(sortedNums[i], i);
        }
        for (int i = 0; i < n; i++) {
            counts[i] = map.get(nums[i]);
        }
        return counts;
    }

    public static void main(String[] args) {
        Task169 solution = new Task169();
        System.out.println(Arrays.toString(solution.smallerNumbersThanCurrent(new int[]{5, 2, 6, 1})));
        System.out.println(Arrays.toString(solution.smallerNumbersThanCurrent(new int[]{-1})));
        System.out.println(Arrays.toString(solution.smallerNumbersThanCurrent(new int[]{-1, -1})));
    }
}