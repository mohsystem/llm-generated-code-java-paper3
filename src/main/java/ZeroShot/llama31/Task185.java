package ZeroShot.llama31;
public class Task185 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int x = nums1.length, y = nums2.length;
        int low = 0, high = x;
        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;
            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = partitionX == x ? Integer.MAX_VALUE : nums1[partitionX];
            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = partitionY == y ? Integer.MAX_VALUE : nums2[partitionY];
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((x + y) % 2 == 0) {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }
        return 0; // This line should not be reached
    }

    public static void main(String[] args) {
        Task185 task = new Task185();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(task.findMedianSortedArrays(nums1, nums2)); // Output: 2.0
        nums1 = new int[] {1, 2};
        nums2 = new int[] {3, 4};
        System.out.println(task.findMedianSortedArrays(nums1, nums2)); // Output: 2.5
        nums1 = new int[] {1, 3, 5};
        nums2 = new int[] {2, 4};
        System.out.println(task.findMedianSortedArrays(nums1, nums2)); // Output: 3.0
        nums1 = new int[] {1};
        nums2 = new int[] {2, 3, 4};
        System.out.println(task.findMedianSortedArrays(nums1, nums2)); // Output: 2.5
        nums1 = new int[] {1, 2};
        nums2 = new int[] {3};
        System.out.println(task.findMedianSortedArrays(nums1, nums2)); // Output: 2.0
    }
}