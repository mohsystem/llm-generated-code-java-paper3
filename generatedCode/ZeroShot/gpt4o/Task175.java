package ZeroShot.openai;
import java.util.*;

interface MountainArray {
    int get(int index);
    int length();
}

class MountainArrayImpl implements MountainArray {
    private int[] array;

    MountainArrayImpl(int[] array) {
        this.array = array;
    }

    public int get(int index) {
        return array[index];
    }

    public int length() {
        return array.length;
    }
}

public class Task175 {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();
        int peak = findPeak(mountainArr, 0, length - 1);

        int index = binarySearch(mountainArr, target, 0, peak, true);
        if (index != -1) {
            return index;
        }

        return binarySearch(mountainArr, target, peak + 1, length - 1, false);
    }

    private int findPeak(MountainArray mountainArr, int left, int right) {
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

    private int binarySearch(MountainArray mountainArr, int target, int left, int right, boolean ascending) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = mountainArr.get(mid);

            if (midValue == target) {
                return mid;
            }
            if (ascending) {
                if (midValue < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (midValue > target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Task175 task = new Task175();
        int[] arr1 = {1, 2, 3, 4, 5, 3, 1};
        int[] arr2 = {0, 1, 2, 4, 2, 1};
        MountainArray mountainArr1 = new MountainArrayImpl(arr1);
        MountainArray mountainArr2 = new MountainArrayImpl(arr2);
        
        System.out.println(task.findInMountainArray(3, mountainArr1)); // Output: 2
        System.out.println(task.findInMountainArray(3, mountainArr2)); // Output: -1
        System.out.println(task.findInMountainArray(5, mountainArr1)); // Output: 4
        System.out.println(task.findInMountainArray(4, mountainArr1)); // Output: 3
        System.out.println(task.findInMountainArray(1, mountainArr2)); // Output: 1
    }
}