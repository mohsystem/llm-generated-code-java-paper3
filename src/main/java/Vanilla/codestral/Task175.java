package Vanilla.codestral;

class MountainArray {
    private int[] arr;

    public MountainArray(int[] arr) {
        this.arr = arr;
    }

    public int get(int index) {
        return arr[index];
    }

    public int length() {
        return arr.length;
    }
}

class Solution3 {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int peak = findPeak(mountainArr, n);
        int left = binarySearch(mountainArr, 0, peak, target, true);
        if (left != -1) {
            return left;
        }
        return binarySearch(mountainArr, peak + 1, n - 1, target, false);
    }

    private int findPeak(MountainArray mountainArr, int n) {
        int low = 0, high = n - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int binarySearch(MountainArray mountainArr, int low, int high, int target, boolean ascending) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midVal = mountainArr.get(mid);
            if (midVal == target) {
                return mid;
            }
            if (ascending) {
                if (midVal < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (midVal > target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}