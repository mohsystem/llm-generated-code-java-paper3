package CoT.codestral;
public class Task171 {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) return 0;
        int mid = left + (right - left) / 2;
        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
        for (int i = left, j = mid + 1; i <= mid; i++) {
            while (j <= right && nums[i] / 2.0 > nums[j]) j++;
            count += j - (mid + 1);
        }
        Arrays.sort(nums, left, right + 1);
        return count;
    }

    public static void main(String[] args) {
        Task171 task = new Task171();
        System.out.println(task.reversePairs(new int[]{1, 3, 2, 3, 1})); // Output: 2
        System.out.println(task.reversePairs(new int[]{2, 4, 3, 5, 1})); // Output: 3
    }
}