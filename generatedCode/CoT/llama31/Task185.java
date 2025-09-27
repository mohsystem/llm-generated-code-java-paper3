package CoT.llama31;
public class Task185 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int left = 0, right = m;
        while (left <= right) {
            int i = (left + right) / 2;
            int j = (m + n + 1) / 2 - i;
            double maxLeftX = (i == 0) ? Double.NEGATIVE_INFINITY : nums1[i - 1];
            double minRightX = (i == m) ? Double.POSITIVE_INFINITY : nums1[i];
            double maxLeftY = (j == 0) ? Double.NEGATIVE_INFINITY : nums2[j - 1];
            double minRightY = (j == n) ? Double.POSITIVE_INFINITY : nums2[j];
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                right = i - 1;
            } else {
                left = i + 1;
            }
        }
        return 0.0; // This line should not be reached
    }

    public static void main(String[] args) {
        Task185 task = new Task185();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(task.findMedianSortedArrays(nums1, nums2)); // Output: 2.0

        nums1 = new int[] {1, 2};
        nums2 = new int[] {3, 4};
        System.out.println(task.findMedianSortedArrays(nums1, nums2)); // Output: 2.5

        nums1 = new int[] {1, 2, 3, 4};
        nums2 = new int[] {5, 6, 7, 8};
        System.out.println(task.findMedianSortedArrays(nums1, nums2)); // Output: 4.5

        nums1 = new int[] {1, 3, 5};
        nums2 = new int[] {2, 4};
        System.out.println(task.findMedianSortedArrays(nums1, nums2)); // Output: 3.0

        nums1 = new int[] {0, 0};
        nums2 = new int[] {0, 0};
        System.out.println(task.findMedianSortedArrays(nums1, nums2)); // Output: 0.0
    }
}