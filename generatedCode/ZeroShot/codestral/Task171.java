package ZeroShot.codestral;
class Task171 {
    int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        int count = mergeSort(nums, start, mid) + mergeSort(nums, mid + 1, end);
        for (int i = start, j = mid + 1; i <= mid; i++) {
            while (j <= end && nums[i] / 2.0 > nums[j]) {
                j++;
            }
            count += j - (mid + 1);
        }
        Arrays.sort(nums, start, end + 1);
        return count;
    }

    public static void main(String[] args) {
        Task171 task = new Task171();
        System.out.println(task.reversePairs(new int[]{1,3,2,3,1})); // Output: 2
        System.out.println(task.reversePairs(new int[]{2,4,3,5,1})); // Output: 3
    }
}