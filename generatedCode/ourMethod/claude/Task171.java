package ourMethod.claude;

public class Task171 {
    private static int merge(int[] nums, int low, int mid, int high) {
        int count = 0;
        int j = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (j <= high && nums[i] > 2L * nums[j]) {
                j++;
            }
            count += j - (mid + 1);
        }
        
        int[] temp = new int[high - low + 1];
        int left = low, right = mid + 1, k = 0;
        
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp[k++] = nums[left++];
            } else {
                temp[k++] = nums[right++];
            }
        }
        
        while (left <= mid) {
            temp[k++] = nums[left++];
        }
        while (right <= high) {
            temp[k++] = nums[right++];
        }
        
        System.arraycopy(temp, 0, nums, low, temp.length);
        return count;
    }
    
    private static int mergeSort(int[] nums, int low, int high) {
        if (low >= high) return 0;
        
        int mid = low + (high - low) / 2;
        int count = mergeSort(nums, low, mid);
        count += mergeSort(nums, mid + 1, high);
        count += merge(nums, low, mid, high);
        
        return count;
    }
    
    public static int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        return mergeSort(nums, 0, nums.length - 1);
    }
    
    public static void main(String[] args) {
        // Test cases
        int[][] testCases = {
            {1, 3, 2, 3, 1},
            {2, 4, 3, 5, 1},
            {1, 1, 1, 1, 1},
            {5, 4, 3, 2, 1},
            {1}
        };
        
        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test case " + (i + 1) + ": " + 
                             reversePairs(testCases[i]));
        }
    }
}
