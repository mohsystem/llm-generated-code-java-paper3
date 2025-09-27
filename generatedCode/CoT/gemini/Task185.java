package CoT.gemini;
import java.util.Arrays;

class Task185 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] merged = new int[m + n];
        System.arraycopy(nums1, 0, merged, 0, m);
        System.arraycopy(nums2, 0, merged, m, n);
        Arrays.sort(merged);

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

        int[] nums51 = {1,2,3,4,5};
        int[] nums52 = {1,2,3,4,5};
        System.out.println(task.findMedianSortedArrays(nums51, nums52)); // Output: 3.0

    }
}