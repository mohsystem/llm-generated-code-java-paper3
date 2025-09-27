package ZeroShot.codestral;
import java.util.*;

public class Task169 {
    static int[] bit;
    static int n;

    public static void main(String[] args) {
        int[] nums = {5,2,6,1};
        System.out.println(Arrays.toString(countSmaller(nums)));
    }

    static int[] countSmaller(int[] nums) {
        Map<Integer, Integer> values = new HashMap<>();
        for (int num : nums) {
            values.put(num, values.getOrDefault(num, 0) + 1);
        }

        int rank = 0;
        TreeMap<Integer, Integer> ranks = new TreeMap<>();
        for (int num : values.keySet()) {
            ranks.put(num, rank++);
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = ranks.get(nums[i]);
        }

        n = rank;
        bit = new int[n + 1];
        int[] ans = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] = query(nums[i]);
            update(nums[i]);
        }

        return ans;
    }

    static void update(int x) {
        for (; x <= n; x += x & -x) {
            bit[x]++;
        }
    }

    static int query(int x) {
        int ans = 0;
        for (; x > 0; x -= x & -x) {
            ans += bit[x];
        }
        return ans;
    }
}