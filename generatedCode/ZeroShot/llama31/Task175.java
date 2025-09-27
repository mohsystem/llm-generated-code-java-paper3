package ZeroShot.llama31;
class Task175 {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int peakIndex = findPeak(mountainArr, 0, n - 1);
        int index = binarySearch(mountainArr, 0, peakIndex, target, true);
        if (index != -1) return index;
        return binarySearch(mountainArr, peakIndex, n - 1, target, false);
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

    private int binarySearch(MountainArray mountainArr, int left, int right, int target, boolean isIncreasing) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = mountainArr.get(mid);
            if (midValue == target) return mid;
            if (isIncreasing) {
                if (midValue < target) left = mid + 1;
                else right = mid - 1;
            } else {
                if (midValue < target) right = mid - 1;
                else left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Task175 task = new Task175();
        // Example usage
        MountainArray mountainArr = new MountainArray(new int[] {1, 2, 3, 4, 5, 3, 1});
        System.out.println(task.findInMountainArray(3, mountainArr)); // Output: 2
        mountainArr = new MountainArray(new int[] {0, 1, 2, 4, 2, 1});
        System.out.println(task.findInMountainArray(3, mountainArr)); // Output: -1
    }
}

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