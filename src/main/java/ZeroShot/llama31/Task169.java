package ZeroShot.llama31;
public class Task169 {
    public static int[] countSmaller(int[] nums) {
        int n = nums.length;
        int[] counts = new int[n];
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        mergeSort(nums, indices, counts, 0, n - 1);
        return counts;
    }

    private static void mergeSort(int[] nums, int[] indices, int[] counts, int start, int end) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        mergeSort(nums, indices, counts, start, mid);
        mergeSort(nums, indices, counts, mid + 1, end);
        merge(nums, indices, counts, start, mid, end);
    }

    private static void merge(int[] nums, int[] indices, int[] counts, int start, int mid, int end) {
        int[] left = new int[mid - start + 1];
        int[] right = new int[end - mid];
        for (int i = 0; i < left.length; i++) {
            left[i] = nums[start + i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = nums[mid + 1 + i];
        }
        int i = 0, j = 0, k = start;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                indices[k] = start + i;
                counts[start + i] += j;
                k++;
                i++;
            } else {
                indices[k] = mid + 1 + j;
                k++;
                j++;
            }
        }
        while (i < left.length) {
            indices[k] = start + i;
            counts[start + i] += j;
            k++;
            i++;
        }
        while (j < right.length) {
            indices[k] = mid + 1 + j;
            k++;
            j++;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {5, 2, 6, 1};
        int[] result1 = countSmaller(nums1);
        System.out.println(java.util.Arrays.toString(result1)); // [2, 1, 1, 0]

        int[] nums2 = {-1};
        int[] result2 = countSmaller(nums2);
        System.out.println(java.util.Arrays.toString(result2)); // [0]

        int[] nums3 = {-1, -1};
        int[] result3 = countSmaller(nums3);
        System.out.println(java.util.Arrays.toString(result3)); // [0, 0]

        int[] nums4 = {12, 1, 2, 3, 0, 11, 4};
        int[] result4 = countSmaller(nums4);
        System.out.println(java.util.Arrays.toString(result4)); // [6, 1, 1, 1, 0, 1, 0]

        int[] nums5 = {5, 4, 3, 2, 1};
        int[] result5 = countSmaller(nums5);
        System.out.println(java.util.Arrays.toString(result5)); // [4, 3, 2, 1, 0]
    }
}