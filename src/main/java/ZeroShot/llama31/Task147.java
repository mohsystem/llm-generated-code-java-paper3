package ZeroShot.llama31;
public class Task147 {
    public static int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private static int quickSelect(int[] nums, int left, int right, int kSmallest) {
        if (left == right) {
            return nums[left];
        }
        int pivotIndex = partition(nums, left, right);
        if (kSmallest == pivotIndex) {
            return nums[kSmallest];
        } else if (kSmallest < pivotIndex) {
            return quickSelect(nums, left, pivotIndex - 1, kSmallest);
        } else {
            return quickSelect(nums, pivotIndex + 1, right, kSmallest);
        }
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                swap(nums, storeIndex, i);
                storeIndex++;
            }
        }
        swap(nums, storeIndex, right);
        return storeIndex;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println("Kth largest element: " + findKthLargest(nums, 2));

        nums = new int[] {10, 9, 8, 7, 6, 5};
        System.out.println("Kth largest element: " + findKthLargest(nums, 3));

        nums = new int[] {1, 2, 3, 4, 5};
        System.out.println("Kth largest element: " + findKthLargest(nums, 1));

        nums = new int[] {5, 4, 3, 2, 1};
        System.out.println("Kth largest element: " + findKthLargest(nums, 5));

        nums = new int[] {10, 20, 30, 40, 50};
        System.out.println("Kth largest element: " + findKthLargest(nums, 4));
    }
}