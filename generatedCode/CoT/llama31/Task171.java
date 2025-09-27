package CoT.llama31;
public class Task171 {
    public static int countReversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private static int mergeSort(int[] nums, int low, int high) {
        if (low >= high) return 0;
        int mid = low + (high - low) / 2;
        int left = mergeSort(nums, low, mid);
        int right = mergeSort(nums, mid + 1, high);
        return left + right + merge(nums, low, mid, high);
    }

    private static int merge(int[] nums, int low, int mid, int high) {
        int[] left = new int[mid - low + 1];
        int[] right = new int[high - mid];
        for (int i = 0; i < left.length; i++) {
            left[i] = nums[low + i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = nums[mid + 1 + i];
        }
        int i = 0, j = 0, k = low, count = 0;
        while (i < left.length && j < right.length) {
            if (left[i] > 2 * right[j]) {
                count += left.length - i;
                nums[k++] = right[j++];
            } else {
                nums[k++] = left[i++];
            }
        }
        while (i < left.length) {
            nums[k++] = left[i++];
        }
        while (j < right.length) {
            nums[k++] = right[j++];
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 2, 3, 1};
        int[] nums2 = {2, 4, 3, 5, 1};
        int[] nums3 = {1, 2, 3, 4, 5};
        int[] nums4 = {5, 4, 3, 2, 1};
        int[] nums5 = {1, 1, 1, 1, 1};

        System.out.println("Reverse pairs for " + java.util.Arrays.toString(nums1) + ": " + countReversePairs(nums1));
        System.out.println("Reverse pairs for " + java.util.Arrays.toString(nums2) + ": " + countReversePairs(nums2));
        System.out.println("Reverse pairs for " + java.util.Arrays.toString(nums3) + ": " + countReversePairs(nums3));
        System.out.println("Reverse pairs for " + java.util.Arrays.toString(nums4) + ": " + countReversePairs(nums4));
        System.out.println("Reverse pairs for " + java.util.Arrays.toString(nums5) + ": " + countReversePairs(nums5));
    }
}