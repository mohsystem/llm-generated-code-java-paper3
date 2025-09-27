package Vanilla.llama31;
public class Task171 {
    public static int countReversePairs(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > 2 * nums[j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 2, 3, 1};
        int[] nums2 = {2, 4, 3, 5, 1};
        int[] nums3 = {3, 2, 4, 5, 1, 20};
        int[] nums4 = {1, 2, 3, 4, 5};
        int[] nums5 = {5, 4, 3, 2, 1};

        System.out.println("Reverse pairs for nums1: " + countReversePairs(nums1));
        System.out.println("Reverse pairs for nums2: " + countReversePairs(nums2));
        System.out.println("Reverse pairs for nums3: " + countReversePairs(nums3));
        System.out.println("Reverse pairs for nums4: " + countReversePairs(nums4));
        System.out.println("Reverse pairs for nums5: " + countReversePairs(nums5));
    }
}