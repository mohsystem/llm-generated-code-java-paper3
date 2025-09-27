package Vanilla.claude;

class Task185 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int x = nums1.length;
        int y = nums2.length;
        
        int low = 0;
        int high = x;
        
        while (low <= high) {
            int partitionX = (low + high)/2;
            int partitionY = (x + y + 1)/2 - partitionX;
            
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];
            
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];
            
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((x + y) % 2 == 0) {
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                } else {
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            }
            else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            }
            else {
                low = partitionX + 1;
            }
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        Task185 task = new Task185();

        // Test case 1
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println("Test 1: " + task.findMedianSortedArrays(nums1, nums2)); // Expected: 2.0

        // Test case 2
        int[] nums3 = {1,2};
        int[] nums4 = {3,4};
        System.out.println("Test 2: " + task.findMedianSortedArrays(nums3, nums4)); // Expected: 2.5

        // Test case 3
        int[] nums5 = {0,0};
        int[] nums6 = {0,0};
        System.out.println("Test 3: " + task.findMedianSortedArrays(nums5, nums6)); // Expected: 0.0

        // Test case 4
        int[] nums7 = {};
        int[] nums8 = {1};
        System.out.println("Test 4: " + task.findMedianSortedArrays(nums7, nums8)); // Expected: 1.0

        // Test case 5
        int[] nums9 = {2};
        int[] nums10 = {};
        System.out.println("Test 5: " + task.findMedianSortedArrays(nums9, nums10)); // Expected: 2.0
    }
}
