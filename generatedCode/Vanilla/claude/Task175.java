package Vanilla.claude;

class MountainArray {
    private int[] arr;
    MountainArray(int[] arr) {
        this.arr = arr;
    }
    public int get(int index) {
        return arr[index];
    }
    public int length() {
        return arr.length;
    }
}

class Task175 {
    public static int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int peakIndex = findPeakIndex(mountainArr);
        
        int leftResult = binarySearch(mountainArr, target, 0, peakIndex, true);
        if (leftResult != -1) return leftResult;
        
        return binarySearch(mountainArr, target, peakIndex + 1, n - 1, false);
    }
    
    private static int findPeakIndex(MountainArray arr) {
        int left = 0;
        int right = arr.length() - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr.get(mid) < arr.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    
    private static int binarySearch(MountainArray arr, int target, int left, int right, boolean increasing) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = arr.get(mid);
            
            if (midVal == target) {
                return mid;
            }
            
            if (increasing) {
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
        // Test cases
        int[][] testArrays = {
            {1,2,3,4,5,3,1},
            {0,1,2,4,2,1},
            {1,3,5,7,6,4,2},
            {1,2,3,4,5,4,3,2,1},
            {1,5,2}
        };
        int[] targets = {3, 3, 7, 4, 2};
        
        for (int i = 0; i < testArrays.length; i++) {
            MountainArray mountainArr = new MountainArray(testArrays[i]);
            int result = findInMountainArray(targets[i], mountainArr);
            System.out.println("Test case " + (i+1) + ": " + result);
        }
    }
}
