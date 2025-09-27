package ZeroShot.gpt4o;
public class Task171 {
    public static void main(String[] args) {
        int[] test1 = {1, 3, 2, 3, 1};
        int[] test2 = {2, 4, 3, 5, 1};
        int[] test3 = {5, 4, 3, 2, 1};
        int[] test4 = {1, 10, 100, 1000, 10000};
        int[] test5 = {5, 8, 9, 3, 2};

        System.out.println(reversePairs(test1)); // 2
        System.out.println(reversePairs(test2)); // 3
        System.out.println(reversePairs(test3)); // 0
        System.out.println(reversePairs(test4)); // 0
        System.out.println(reversePairs(test5)); // 4
    }

    public static int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        return mergeSort(nums, 0, nums.length - 1);
    }

    private static int mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
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
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            temp[k++] = nums[j++];
        }
        for (i = left; i <= right; i++) {
            nums[i] = temp[i - left];
        }
    }
}