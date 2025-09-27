package Vanilla.codestral;
import java.util.Arrays;
import java.util.Collections;

public class Task147 {
    public static Integer findKthLargest(Integer[] nums, int k) {
        Arrays.sort(nums, Collections.reverseOrder());
        return nums[k - 1];
    }

    public static void main(String[] args) {
        Integer[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));  // Output: 5
    }
}