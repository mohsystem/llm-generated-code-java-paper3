package ourMethod.gpt4o;
import java.util.Arrays;

public class Task169 {
    public static int[] countSmaller(int[] nums) {
        int n = nums.length;
        int[] counts = new int[n];
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) indices[i] = i;
        mergeSort(nums, indices, 0, n, counts);
        return counts;
    }

    private static void mergeSort(int[] nums, Integer[] indices, int left, int right, int[] counts) {
        if (right - left <= 1) return;
        int mid = (left + right) / 2;
        mergeSort(nums, indices, left, mid, counts);
        mergeSort(nums, indices, mid, right, counts);
        merge(nums, indices, left, mid, right, counts);
    }

    private static void merge(int[] nums, Integer[] indices, int left, int mid, int right, int[] counts) {
        Integer[] temp = new Integer[right - left];
        int i = left, j = mid, k = 0;
        while (i < mid && j < right) {
            if (nums[indices[i]] <= nums[indices[j]]) {
                counts[indices[i]] += j - mid;
                temp[k++] = indices[i++];
            } else {
                temp[k++] = indices[j++];
            }
        }
        while (i < mid) {
            counts[indices[i]] += j - mid;
            temp[k++] = indices[i++];
        }
        while (j < right) {
            temp[k++] = indices[j++];
        }
        System.arraycopy(temp, 0, indices, left, right - left);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countSmaller(new int[]{5, 2, 6, 1})));
        System.out.println(Arrays.toString(countSmaller(new int[]{-1})));
        System.out.println(Arrays.toString(countSmaller(new int[]{-1, -1})));
        System.out.println(Arrays.toString(countSmaller(new int[]{2, 0, 1})));
        System.out.println(Arrays.toString(countSmaller(new int[]{4, 3, 2, 1})));
    }
}