package CoT.codestral;
interface MountainArray {
    public int get(int index);
    public int length();
}

class Task175 {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = findPeak(mountainArr);
        int left = binarySearch(mountainArr, 0, peak, target);
        if (left != -1) {
            return left;
        }
        return binarySearch(mountainArr, peak + 1, mountainArr.length() - 1, target);
    }

    private int findPeak(MountainArray mountainArr) {
        int left = 0, right = mountainArr.length() - 1;
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

    private int binarySearch(MountainArray mountainArr, int left, int right, int target) {
        boolean asc = mountainArr.get(left) < mountainArr.get(right);
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) == target) {
                return mid;
            }
            if (asc) {
                if (mountainArr.get(mid) < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (mountainArr.get(mid) > target) {
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
        System.out.println(task.findInMountainArray(3, new MountainArray() {
            int[] arr = {1,2,3,4,5,3,1};
            public int get(int index) { return arr[index]; }
            public int length() { return arr.length; }
        }));
        System.out.println(task.findInMountainArray(3, new MountainArray() {
            int[] arr = {0,1,2,4,2,1};
            public int get(int index) { return arr[index]; }
            public int length() { return arr.length; }
        }));
    }
}