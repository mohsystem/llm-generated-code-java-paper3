package ourMethod.claude;

interface MountainArray {
    public int get(int index);
    public int length();
}

class Task175 {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();
        int peakIndex = findPeakIndex(mountainArr, 0, length - 1);
        
        // Search in the increasing part
        int result = binarySearch(mountainArr, target, 0, peakIndex, true);
        if (result != -1) return result;
        
        // Search in the decreasing part
        return binarySearch(mountainArr, target, peakIndex + 1, length - 1, false);
    }
    
    private int findPeakIndex(MountainArray mountainArr, int left, int right) {
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
    
    private int binarySearch(MountainArray mountainArr, int target, int left, int right, boolean increasing) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = mountainArr.get(mid);
            
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
        // Test cases cannot be implemented as MountainArray is an interface
        System.out.println("Test cases would need actual implementation of MountainArray interface");
    }
}
