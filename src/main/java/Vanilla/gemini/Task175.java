package Vanilla.gemini;
import java.util.List;
import java.util.ArrayList;

interface MountainArray {
    public int get(int index);
    public int length();
}


class Task175 {
     public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int peakIndex = findPeakIndex(mountainArr, n);

        int leftIndex = binarySearch(mountainArr, 0, peakIndex, target, true);
        if (leftIndex != -1) {
            return leftIndex;
        }

        return binarySearch(mountainArr, peakIndex + 1, n - 1, target, false);
    }

    private int findPeakIndex(MountainArray mountainArr, int n) {
        int left = 0, right = n - 1;
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

    private int binarySearch(MountainArray mountainArr, int left, int right, int target, boolean ascending) {
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
        Task175 task = new Task175();
        List<MountainArray> testCases = new ArrayList<>();
        List<Integer> targets = new ArrayList<>();
        List<int[]> arrays = new ArrayList<>();

        arrays.add(new int[]{1, 2, 3, 4, 5, 3, 1});
        targets.add(3);
        arrays.add(new int[]{0, 1, 2, 4, 2, 1});
        targets.add(3);
        arrays.add(new int[]{1, 5, 2});
        targets.add(2);
        arrays.add(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1});
        targets.add(9);
        arrays.add(new int[]{1, 2, 3, 4, 5, 3, 1});
        targets.add(0);

        for(int[] arr: arrays) {
            testCases.add(new MountainArray() {
                int[] array = arr;
                public int get(int index) { return array[index]; }
                public int length() { return array.length; }
            });
        }
        for (int i = 0; i < testCases.size(); i++) {
            System.out.println("Test Case " + (i + 1) + ": " + task.findInMountainArray(targets.get(i), testCases.get(i)));
        }
    }
}