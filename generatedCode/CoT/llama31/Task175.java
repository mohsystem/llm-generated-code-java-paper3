package CoT.llama31;
class Task175 {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int peak = findPeak(mountainArr, 0, n - 1);
        int index = binarySearch(mountainArr, 0, peak, target, true);
        if (index != -1) return index;
        return binarySearch(mountainArr, peak, n - 1, target, false);
    }

    private int findPeak(MountainArray mountainArr, int l, int r) {
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    private int binarySearch(MountainArray mountainArr, int l, int r, int target, boolean ascending) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midVal = mountainArr.get(mid);
            if (midVal == target) return mid;
            if (ascending) {
                if (midVal < target) l = mid + 1;
                else r = mid - 1;
            } else {
                if (midVal < target) r = mid - 1;
                else l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // Test cases
        Task175 task = new Task175();
        MountainArray mountainArr1 = new MountainArray(new int[] {1, 2, 3, 4, 5, 3, 1});
        System.out.println(task.findInMountainArray(3, mountainArr1)); // Output: 2

        MountainArray mountainArr2 = new MountainArray(new int[] {0, 1, 2, 4, 2, 1});
        System.out.println(task.findInMountainArray(3, mountainArr2)); // Output: -1
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