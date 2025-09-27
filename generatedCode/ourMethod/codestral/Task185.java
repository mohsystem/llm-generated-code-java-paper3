package ourMethod.codestral;
import java.util.Arrays;

public class Task185 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, merged, 0, nums1.length);
        System.arraycopy(nums2, 0, merged, nums1.length, nums2.length);
        Arrays.sort(merged);

        int n = merged.length;
        if (n % 2 == 0) {
            return (merged[n / 2 - 1] + merged[n / 2]) / 2.0;
        } else {
            return merged[n / 2];
        }
    }

    public static void main(String[] args) {
        Task185 task = new Task185();
        System.out.println(task.findMedianSortedArrays(new int[]{1, 3}, new int[]{2})); // 2.0
        System.out.println(task.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4})); // 2.5
    }
}