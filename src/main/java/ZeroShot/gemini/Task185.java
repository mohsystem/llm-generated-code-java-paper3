package ZeroShot.gemini;
class Task185 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int low = 0, high = m;
        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (m + n + 1) / 2 - partitionX;

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((m + n) % 2 == 0) {
                    return (double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        Task185 task = new Task185();
        int[] nums11 = {1, 3};
        int[] nums12 = {2};
        System.out.println(task.findMedianSortedArrays(nums11, nums12)); // Output: 2.0

        int[] nums21 = {1, 2};
        int[] nums22 = {3, 4};
        System.out.println(task.findMedianSortedArrays(nums21, nums22)); // Output: 2.5

        int[] nums31 = {};
        int[] nums32 = {1};
        System.out.println(task.findMedianSortedArrays(nums31, nums32)); // Output: 1.0

        int[] nums41 = {2};
        int[] nums42 = {};
        System.out.println(task.findMedianSortedArrays(nums41, nums42)); // Output: 2.0


        int[] nums51 = {1,2,5};
        int[] nums52 = {3,4,6};
        System.out.println(task.findMedianSortedArrays(nums51, nums52)); // Output: 3.5
    }
}