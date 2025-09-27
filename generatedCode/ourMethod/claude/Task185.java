package ourMethod.claude;

public class Task185 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int x = nums1.length;
        int y = nums2.length;
        int low = 0;
        int high = x;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            // Find max and min of left and right partitions
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // Found correct partition
                if ((x + y) % 2 == 0) {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }
        throw new IllegalArgumentException("Input arrays are not sorted");
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2)); // Expected: 2.0

        // Test Case 2
        nums1 = new int[]{1, 2};
        nums2 = new int[]{3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2)); // Expected: 2.5

        // Test Case 3
        nums1 = new int[]{0, 0};
        nums2 = new int[]{0, 0};
        System.out.println(findMedianSortedArrays(nums1, nums2)); // Expected: 0.0

        // Test Case 4
        nums1 = new int[]{};
        nums2 = new int[]{1};
        System.out.println(findMedianSortedArrays(nums1, nums2)); // Expected: 1.0

        // Test Case 5
        nums1 = new int[]{2};
        nums2 = new int[]{};
        System.out.println(findMedianSortedArrays(nums1, nums2)); // Expected: 2.0
    }
}
