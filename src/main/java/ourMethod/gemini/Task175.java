package ourMethod.gemini;
/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 

import java.util.Arrays;
interface MountainArray {
    public int get(int index);
    public int length();
}
class Task175 {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int peakIndex = findPeakIndex(mountainArr, 0, n - 1);

        int leftIndex = findTarget(mountainArr, target, 0, peakIndex, true);
        if (leftIndex != -1) {
            return leftIndex;
        }

        return findTarget(mountainArr, target, peakIndex + 1, n - 1, false);
    }

    private int findPeakIndex(MountainArray mountainArr, int left, int right) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int findTarget(MountainArray mountainArr, int target, int left, int right, boolean ascending) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int val = mountainArr.get(mid);

            if (val == target) {
                return mid;
            } else if (ascending && val < target || !ascending && val > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Task175 solution = new Task175();

        // Test cases
        int[] arr1 = {1, 2, 3, 4, 5, 3, 1};
        int target1 = 3;
        MountainArray mountainArr1 = new MountainArrayImpl(arr1);
        System.out.println(solution.findInMountainArray(target1, mountainArr1)); // Output: 2

        int[] arr2 = {0, 1, 2, 4, 2, 1};
        int target2 = 3;
        MountainArray mountainArr2 = new MountainArrayImpl(arr2);
        System.out.println(solution.findInMountainArray(target2, mountainArr2)); // Output: -1
        
        int[] arr3 = {1, 5, 2};
        int target3 = 2;
        MountainArray mountainArr3 = new MountainArrayImpl(arr3);
        System.out.println(solution.findInMountainArray(target3, mountainArr3)); // Output: 2

        int[] arr4 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int target4 = 0;
        MountainArray mountainArr4 = new MountainArrayImpl(arr4);
        System.out.println(solution.findInMountainArray(target4, mountainArr4)); // Output: 19

        int[] arr5 = {0, 5, 3, 1};
        int target5 = 1;
        MountainArray mountainArr5 = new MountainArrayImpl(arr5);
        System.out.println(solution.findInMountainArray(target5, mountainArr5)); // Output: 3
    }
}


class MountainArrayImpl implements MountainArray {
    private int[] arr;

    public MountainArrayImpl(int[] arr) {
        this.arr = arr;
    }

    @Override
    public int get(int index) {
        return arr[index];
    }

    @Override
    public int length() {
        return arr.length;
    }
}