package ourMethodv2.gpt4o;
import java.util.Arrays;

interface MountainArray {
    int get(int index);
    int length();
}

class MountainArrayImpl implements MountainArray {
    private int[] arr;

    public MountainArrayImpl(int[] arr) {
        this.arr = arr;
    }

    public int get(int index) {
        return arr[index];
    }

    public int length() {
        return arr.length;
    }
}

public class Task175 {

    public static int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = findPeak(mountainArr);
        int result = binarySearch(mountainArr, target, 0, peak, true);
        if (result != -1) {
            return result;
        }
        return binarySearch(mountainArr, target, peak + 1, mountainArr.length() - 1, false);
    }

    private static int findPeak(MountainArray mountainArr) {
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

    private static int binarySearch(MountainArray mountainArr, int target, int left, int right, boolean asc) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int value = mountainArr.get(mid);
            if (value == target) {
                return mid;
            }
            if (asc) {
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
        MountainArrayImpl array1 = new MountainArrayImpl(new int[]{1, 2, 3, 4, 5, 3, 1});
        MountainArrayImpl array2 = new MountainArrayImpl(new int[]{0, 1, 2, 4, 2, 1});
        MountainArrayImpl array3 = new MountainArrayImpl(new int[]{3, 5, 3, 2, 0});
        MountainArrayImpl array4 = new MountainArrayImpl(new int[]{0, 2, 3, 4, 5, 4, 3, 2, 1});
        MountainArrayImpl array5 = new MountainArrayImpl(new int[]{1, 3, 5, 7, 6, 4, 2, 1});
        
        System.out.println(findInMountainArray(3, array1)); // Output: 2
        System.out.println(findInMountainArray(3, array2)); // Output: -1
        System.out.println(findInMountainArray(2, array3)); // Output: 3
        System.out.println(findInMountainArray(5, array4)); // Output: 4
        System.out.println(findInMountainArray(7, array5)); // Output: 3
    }
}