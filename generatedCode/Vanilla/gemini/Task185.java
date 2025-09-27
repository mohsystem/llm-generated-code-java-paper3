package Vanilla.gemini;
class Task185 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int[] merged = new int[len];
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

        if (len % 2 == 0) {
            return (double) (merged[len / 2 - 1] + merged[len / 2]) / 2;
        } else {
            return (double) merged[len / 2];
        }
    }

    public static void main(String[] args) {
        Task185 task = new Task185();
        int[] nums11 = {1, 3};
        int[] nums12 = {2};
        System.out.println(task.findMedianSortedArrays(nums11, nums12)); // 2.0

        int[] nums21 = {1, 2};
        int[] nums22 = {3, 4};
        System.out.println(task.findMedianSortedArrays(nums21, nums22)); // 2.5

        int[] nums31 = {};
        int[] nums32 = {1};
        System.out.println(task.findMedianSortedArrays(nums31, nums32)); // 1.0

        int[] nums41 = {2};
        int[] nums42 = {};
        System.out.println(task.findMedianSortedArrays(nums41, nums42)); // 2.0

        int[] nums51 = {1,2,4,5,7};
        int[] nums52 = {3,6,8,9};

        System.out.println(task.findMedianSortedArrays(nums51, nums52)); // 5.0
    }
}