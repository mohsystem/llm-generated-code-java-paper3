package Vanilla.llama31;
public class Task175 {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int peak = findPeak(mountainArr, 0, n - 1);
        int index = binarySearch(mountainArr, 0, peak, target, true);
        if (index != -1) return index;
        return binarySearch(mountainArr, peak, n - 1, target, false);
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

    private int binarySearch(MountainArray mountainArr, int left, int right, int target, boolean isAscending) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = mountainArr.get(mid);
            if (midVal == target) return mid;
            if (isAscending) {
                if (midVal < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (midVal < target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Task175 task = new Task175();
        MountainArray mountainArr1 = new MountainArray(new int[] {1, 2, 3, 4, 5, 3, 1});
        System.out.println(task.findInMountainArray(3, mountainArr1)); // Output: 2

        MountainArray mountainArr2 = new MountainArray(new int[] {0, 1, 2, 4, 2, 1});
        System.out.println(task.findInMountainArray(3, mountainArr2)); // Output: -1

        MountainArray mountainArr3 = new MountainArray(new int[] {3, 5, 1});
        System.out.println(task.findInMountainArray(3, mountainArr3)); // Output: 0

        MountainArray mountainArr4 = new MountainArray(new int[] {1, 2, 3, 4, 5, 2, 1, 0});
        System.out.println(task.findInMountainArray(3, mountainArr4)); // Output: 2

        MountainArray mountainArr5 = new MountainArray(new int[] {0, 1, 2, 3, 4, 5, 4, 3, 2, 1});
        System.out.println(task.findInMountainArray(0, mountainArr5)); // Output: 0
    }
}