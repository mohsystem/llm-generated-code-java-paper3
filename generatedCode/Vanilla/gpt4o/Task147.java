package Vanilla.gpt4o;
public class Task147 {
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        System.out.println(findKthLargest(nums1, k1)); // Output: 5

        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        System.out.println(findKthLargest(nums2, k2)); // Output: 4

        int[] nums3 = {1};
        int k3 = 1;
        System.out.println(findKthLargest(nums3, k3)); // Output: 1

        int[] nums4 = {7, 10, 4, 3, 20, 15};
        int k4 = 3;
        System.out.println(findKthLargest(nums4, k4)); // Output: 10

        int[] nums5 = {7, 10, 4, 20, 15};
        int k5 = 4;
        System.out.println(findKthLargest(nums5, k5)); // Output: 7
    }
}