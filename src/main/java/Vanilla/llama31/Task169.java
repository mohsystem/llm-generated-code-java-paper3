package Vanilla.llama31;
public class Task169 {
    public static int[] countSmaller(int[] nums) {
        int n = nums.length;
        int[] smallerArr = new int[n];
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        mergeSort(nums, indices, smallerArr, 0, n - 1);
        return smallerArr;
    }

    public static void mergeSort(int[] nums, int[] indices, int[] smallerArr, int start, int end) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        mergeSort(nums, indices, smallerArr, start, mid);
        mergeSort(nums, indices, smallerArr, mid + 1, end);
        merge(nums, indices, smallerArr, start, mid, end);
    }

    public static void merge(int[] nums, int[] indices, int[] smallerArr, int start, int mid, int end) {
        int[] left = new int[mid - start + 1];
        int[] right = new int[end - mid];
        for (int i = 0; i < left.length; i++) {
            left[i] = nums[start + i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = nums[mid + 1 + i];
        }
        int l = 0, r = 0, k = start;
        while (l < left.length && r < right.length) {
            if (left[l] <= right[r]) {
                nums[k] = left[l];
                smallerArr[indices[start + l]] += r;
                l++;
            } else {
                nums[k] = right[r];
                r++;
            }
            k++;
        }
        while (l < left.length) {
            nums[k] = left[l];
            smallerArr[indices[start + l]] += r;
            l++;
            k++;
        }
        while (r < right.length) {
            nums[k] = right[r];
            r++;
            k++;
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

        int[] nums4 = {3, 2, 2, 1, 0};
        int[] result4 = countSmaller(nums4);
        System.out.println(java.util.Arrays.toString(result4)); // [3, 2, 1, 0, 0]

        int[] nums5 = {7, 1, 5, 2, 10};
        int[] result5 = countSmaller(nums5);
        System.out.println(java.util.Arrays.toString(result5)); // [3, 0, 0, 2, 0]
    }
}