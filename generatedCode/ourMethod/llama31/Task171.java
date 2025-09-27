package ourMethod.llama31;
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
        int count = 0;
        int[] temp = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;

        while (i <= mid && j <= high) {
            if (nums[i] > 2L * nums[j]) {
                count += mid - i + 1;
                temp[k++] = nums[j++];
            } else {
                temp[k++] = nums[i++];
            }
        }

        while (i <= mid) temp[k++] = nums[i++];
        while (j <= high) temp[k++] = nums[j++];

        System.arraycopy(temp, 0, nums, low, temp.length);
        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 2, 3, 1};
        int[] nums2 = {2, 4, 3, 5, 1};
        int[] nums3 = {1, 2, 3, 4, 5};
        int[] nums4 = {5, 4, 3, 2, 1};
        int[] nums5 = {1, 1, 1, 1, 1};

        System.out.println("Reverse pairs in nums1: " + countReversePairs(nums1));
        System.out.println("Reverse pairs in nums2: " + countReversePairs(nums2));
        System.out.println("Reverse pairs in nums3: " + countReversePairs(nums3));
        System.out.println("Reverse pairs in nums4: " + countReversePairs(nums4));
        System.out.println("Reverse pairs in nums5: " + countReversePairs(nums5));
    }
}