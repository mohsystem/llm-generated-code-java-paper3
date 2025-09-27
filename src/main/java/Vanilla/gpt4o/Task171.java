package Vanilla.gpt4o;
import java.util.Arrays;

public class Task171 {
    public static void main(String[] args) {
        System.out.println(reversePairs(new int[]{1, 3, 2, 3, 1})); // 2
        System.out.println(reversePairs(new int[]{2, 4, 3, 5, 1})); // 3
        System.out.println(reversePairs(new int[]{5, 4, 3, 2, 1})); // 4
        System.out.println(reversePairs(new int[]{1, 2, 3, 4, 5})); // 0
        System.out.println(reversePairs(new int[]{2, 2, 2, 2, 2})); // 0
    }

    public static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private static int mergeSort(int[] nums, int left, int right) {
        if (left >= right) return 0;
        int mid = (left + right) / 2;
        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
        int j = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && nums[i] > 2L * nums[j]) {
                j++;
            }
            count += j - (mid + 1);
        }
        merge(nums, left, mid, right);
        return count;
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) temp[k++] = nums[i++];
        while (j <= right) temp[k++] = nums[j++];
        System.arraycopy(temp, 0, nums, left, temp.length);
    }
}