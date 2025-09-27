package CoT.claude;

public class Task185 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        
        int m = nums1.length;
        int n = nums2.length;
        
        int low = 0;
        int high = m;
        
        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (m + n + 1) / 2 - partitionX;
            
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];
            
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];
            
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((m + n) % 2 == 0) {
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
        Task185 solution = new Task185();
        
        // Test case 1
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2)); // Expected: 2.0
        
        // Test case 2
        nums1 = new int[]{1, 2};
        nums2 = new int[]{3, 4};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2)); // Expected: 2.5
        
        // Test case 3
        nums1 = new int[]{};
        nums2 = new int[]{1};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2)); // Expected: 1.0
        
        // Test case 4
        nums1 = new int[]{2};
        nums2 = new int[]{};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2)); // Expected: 2.0
        
        // Test case 5
        nums1 = new int[]{1, 2, 3, 4, 5};
        nums2 = new int[]{6, 7, 8, 9, 10};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2)); // Expected: 5.5
    }
}
