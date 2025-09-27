package CoT.codestral;
import java.util.*;

public class Task169 {
    public static int[] countSmaller(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        List<Integer> sorted = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            int idx = Collections.binarySearch(sorted, nums[i]);
            if (idx < 0) idx = -(idx + 1);
            sorted.add(idx, nums[i]);
            ans[i] = idx;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countSmaller(new int[]{5, 2, 6, 1})));
        System.out.println(Arrays.toString(countSmaller(new int[]{-1})));
        System.out.println(Arrays.toString(countSmaller(new int[]{-1, -1})));
    }
}