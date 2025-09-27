package ourMethod.gemini;
class Task185 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] merged = new int[m + n];
        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        while (i < m) {
            merged[k++] = nums1[i++];
        }

        while (j < n) {
            merged[k++] = nums2[j++];
        }

        int totalLength = m + n;
        if (totalLength % 2 == 0) {
            return (double) (merged[totalLength / 2 - 1] + merged[totalLength / 2]) / 2;
        } else {
            return (double) merged[totalLength / 2];
        }
    }

    public static void main(String[] args) {
        Task185 task = new Task185();

        int[] nums11 = {1, 3};
        int[] nums21 = {2};
        System.out.println(task.findMedianSortedArrays(nums11, nums21)); // Output: 2.0

        int[] nums12 = {1, 2};
        int[] nums22 = {3, 4};
        System.out.println(task.findMedianSortedArrays(nums12, nums22)); // Output: 2.5

        int[] nums13 = {};
        int[] nums23 = {1};
        System.out.println(task.findMedianSortedArrays(nums13, nums23)); // Output: 1.0

        int[] nums14 = {2};
        int[] nums24 = {};
        System.out.println(task.findMedianSortedArrays(nums14, nums24)); // Output: 2.0


        int[] nums15 = {1, 2, 5};
        int[] nums25 = {3, 4, 6};
        System.out.println(task.findMedianSortedArrays(nums15, nums25)); // Output: 3.5

    }
}