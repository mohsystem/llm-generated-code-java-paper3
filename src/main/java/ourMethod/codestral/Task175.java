package ourMethod.codestral;
// Task175
class Task175 {
    interface MountainArray {
        int get(int index);
        int length();
    }

    public static int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int peak = left;
        left = 0;
        right = peak;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) == target) {
                return mid;
            } else if (mountainArr.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        left = peak;
        right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) == target) {
                return mid;
            } else if (mountainArr.get(mid) > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MountainArray arr1 = new MountainArray() {
            int[] arr = {1,2,3,4,5,3,1};
            public int get(int index) { return arr[index]; }
            public int length() { return arr.length; }
        };
        System.out.println(findInMountainArray(3, arr1)); // Output: 2

        MountainArray arr2 = new MountainArray() {
            int[] arr = {0,1,2,4,2,1};
            public int get(int index) { return arr[index]; }
            public int length() { return arr.length; }
        };
        System.out.println(findInMountainArray(3, arr2)); // Output: -1
    }
}