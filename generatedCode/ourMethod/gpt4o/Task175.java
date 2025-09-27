package ourMethod.gpt4o;
interface MountainArray {
    public int get(int index);
    public int length();
}

public class Task175 {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = findPeak(mountainArr);
        int index = binarySearch(mountainArr, target, 0, peak, true);
        if (index != -1) {
            return index;
        }
        return binarySearch(mountainArr, target, peak + 1, mountainArr.length() - 1, false);
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

    private int binarySearch(MountainArray mountainArr, int target, int left, int right, boolean ascending) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int value = mountainArr.get(mid);
            if (value == target) {
                return mid;
            }
            if (ascending) {
                if (value < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (value > target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MountainArray mountainArr1 = new MountainArray() {
            private int[] arr = {1, 2, 3, 4, 5, 3, 1};

            public int get(int index) {
                return arr[index];
            }

            public int length() {
                return arr.length;
            }
        };

        MountainArray mountainArr2 = new MountainArray() {
            private int[] arr = {0, 1, 2, 4, 2, 1};

            public int get(int index) {
                return arr[index];
            }

            public int length() {
                return arr.length;
            }
        };

        Task175 task = new Task175();
        System.out.println(task.findInMountainArray(3, mountainArr1)); // Output: 2
        System.out.println(task.findInMountainArray(3, mountainArr2)); // Output: -1
    }
}