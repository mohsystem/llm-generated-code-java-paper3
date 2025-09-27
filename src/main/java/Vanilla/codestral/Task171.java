package Vanilla.codestral;
class Task171 {
    private int[] temp;
    private long count;

    public int reversePairs(int[] nums) {
        temp = new int[nums.length];
        sort(nums, 0, nums.length - 1);
        return (int) count;
    }

    private void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        sort(nums, start, mid);
        sort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    private void merge(int[] nums, int start, int mid, int end) {
        for (int i = start, j = mid + 1; i <= mid; i++) {
            while (j <= end && nums[i] / 2.0 > nums[j]) {
                j++;
            }
            count += j - (mid + 1);
        }

        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            temp[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= end) {
            temp[k++] = nums[j++];
        }
        for (i = start, k = 0; i <= end; i++, k++) {
            nums[i] = temp[k];
        }
    }

    public static void main(String[] args) {
        Task171 task = new Task171();
        System.out.println(task.reversePairs(new int[]{1,3,2,3,1}));
        System.out.println(task.reversePairs(new int[]{2,4,3,5,1}));
        System.out.println(task.reversePairs(new int[]{2147483647,2147483647,-2147483647,-2147483647,2147483647,2147483647,-2147483647,-2147483647}));
        System.out.println(task.reversePairs(new int[]{-2147483647,-2147483648,2147483647,2147483647,2147483647,2147483646,2147483646,2147483646,-2147483646}));
        System.out.println(task.reversePairs(new int[]{5,4,3,2,1}));
    }
}