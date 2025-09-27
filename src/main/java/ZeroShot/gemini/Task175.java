package ZeroShot.gemini;
import java.util.List;
import java.util.ArrayList;

interface MountainArray {
    public int get(int index);
    public int length();
}


class MountainArrayImpl implements MountainArray {
    private List<Integer> arr;

    public MountainArrayImpl(List<Integer> arr) {
        this.arr = arr;
    }


    @Override
    public int get(int index) {
        return arr.get(index);
    }

    @Override
    public int length() {
        return arr.size();
    }
}



class Task175 {

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peakIndex = findPeakIndex(mountainArr);
        int leftIndex = binarySearch(mountainArr, target, 0, peakIndex, true);
        if (leftIndex != -1) {
            return leftIndex;
        }
        return binarySearch(mountainArr, target, peakIndex + 1, mountainArr.length() - 1, false);

    }

    private int findPeakIndex(MountainArray mountainArr) {
        int left = 0;
        int right = mountainArr.length() - 1;
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
            int val = mountainArr.get(mid);

            if (val == target) {
                return mid;
            } else if (val < target) {
                if (ascending) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (ascending) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Task175 task = new Task175();
        List<Integer> arr1 = List.of(1, 2, 3, 4, 5, 3, 1);
        MountainArray mountainArr1 = new MountainArrayImpl(arr1);
        System.out.println(task.findInMountainArray(3, mountainArr1)); // Output: 2


        List<Integer> arr2 = List.of(0, 1, 2, 4, 2, 1);
        MountainArray mountainArr2 = new MountainArrayImpl(arr2);
        System.out.println(task.findInMountainArray(3, mountainArr2)); // Output: -1


        List<Integer> arr3 = List.of(0,5,3,1);
        MountainArray mountainArr3 = new MountainArrayImpl(arr3);
        System.out.println(task.findInMountainArray(1, mountainArr3)); // Output: 3


        List<Integer> arr4 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0);
        MountainArray mountainArr4 = new MountainArrayImpl(arr4);
        System.out.println(task.findInMountainArray(10, mountainArr4)); // Output: 9



        List<Integer> arr5 = List.of(1, 2, 3, 4, 5, 4, 3, 2, 1);
        MountainArray mountainArr5 = new MountainArrayImpl(arr5);
        System.out.println(task.findInMountainArray(0, mountainArr5)); // Output: -1
    }
}