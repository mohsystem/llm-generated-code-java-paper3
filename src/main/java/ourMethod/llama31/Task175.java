package ourMethod.llama31;
public class Task175 {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int peak = findPeak(mountainArr, 0, n - 1);
        int index = binarySearch(mountainArr, 0, peak, target, true);
        if (index != -1) return index;
        return binarySearch(mountainArr, peak, n - 1, target, false);
    }

    private int findPeak(MountainArray mountainArr, int l, int r) {
        while (l < r) {
            int m = l + (r - l) / 2;
            if (mountainArr.get(m) < mountainArr.get(m + 1)) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

    private int binarySearch(MountainArray mountainArr, int l, int r, int target, boolean isIncreasing) {
        while (l <= r) {
            int m = l + (r - l) / 2;
            int val = mountainArr.get(m);
            if (val == target) return m;
            if (isIncreasing) {
                if (val < target) l = m + 1;
                else r = m - 1;
            } else {
                if (val < target) r = m - 1;
                else l = m + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Task175 task = new Task175();
        MountainArray mountainArr = new MountainArray(new int[]{1, 2, 3, 4, 5, 3, 1});
        System.out.println(task.findInMountainArray(3, mountainArr)); // Output: 2
        mountainArr = new MountainArray(new int[]{0, 1, 2, 4, 2, 1});
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