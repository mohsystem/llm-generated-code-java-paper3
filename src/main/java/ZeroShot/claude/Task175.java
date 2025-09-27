package ZeroShot.claude;

class MountainArray {
    private int[] arr;
    private int count = 0;
    
    public MountainArray(int[] arr) {
        this.arr = arr;
    }
    
    public int get(int index) {
        if (++count > 100) throw new RuntimeException("Too many calls");
        return arr[index];
    }
    
    public int length() {
        return arr.length;
    }
}

public class Task175 {
    public static int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        // Find peak element
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1))
                left = mid + 1;
            else
                right = mid;
        }
        int peak = left;
        
        // Search in left side
        left = 0;
        right = peak;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = mountainArr.get(mid);
            if (midVal == target)
                return mid;
            else if (midVal < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        
        // Search in right side
        left = peak;
        right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = mountainArr.get(mid);
            if (midVal == target)
                return mid;
            else if (midVal < target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        // Test cases
        int[][] arrays = {
            {1,2,3,4,5,3,1},
            {0,1,2,4,2,1},
            {1,3,5,7,6,4,2},
            {1,2,3,4,5,4,3,2,1},
            {1,5,2}
        };
        int[] targets = {3, 3, 7, 3, 2};
        
        for (int i = 0; i < arrays.length; i++) {
            MountainArray mountainArr = new MountainArray(arrays[i]);
            System.out.println("Test case " + (i+1) + ": " + 
                findInMountainArray(targets[i], mountainArr));
        }
    }
}
