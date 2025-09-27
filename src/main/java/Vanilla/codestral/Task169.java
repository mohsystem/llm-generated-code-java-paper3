package Vanilla.codestral;
import java.util.Arrays;

public class Task169 {
    public static int[] countSmaller(int[] nums) {
        int[] result = new int[nums.length];
        int[] sorted = new int[nums.length];
        System.arraycopy(nums, 0, sorted, 0, nums.length);
        Arrays.sort(sorted);
        for (int i = 0; i < nums.length; i++) {
            result[i] = binarySearch(sorted, nums[i]);
        }
        return result;
    }

    private static int binarySearch(int[] sorted, int target) {
        int left = 0;
        int right = sorted.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (sorted[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left < sorted.length && sorted[left] < target ? left : left - 1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countSmaller(new int[]{5,2,6,1})));
        System.out.println(Arrays.toString(countSmaller(new int[]{-1})));
        System.out.println(Arrays.toString(countSmaller(new int[]{-1,-1})));
    }
}