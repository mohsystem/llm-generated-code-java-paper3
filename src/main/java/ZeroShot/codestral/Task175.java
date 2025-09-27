package ZeroShot.codestral;
// Java
public class Task175 {
    public interface MountainArray {
        public int get(int index);
        public int length();
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int peak = findPeak(mountainArr, 0, n - 1);
        int left = binarySearch(mountainArr, 0, peak, target);
        if (left != -1) return left;
        return binarySearch(mountainArr, peak + 1, n - 1, target);
    }

    private int findPeak(MountainArray mountainArr, int l, int r) {
        while (l < r) {
            int m = l + (r - l) / 2;
            if (mountainArr.get(m) < mountainArr.get(m + 1)) l = m + 1;
            else r = m;
        }
        return l;
    }

    private int binarySearch(MountainArray mountainArr, int l, int r, int target) {
        boolean asc = mountainArr.get(l) < mountainArr.get(r);
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (mountainArr.get(m) == target) return m;
            if (asc) {
                if (mountainArr.get(m) < target) l = m + 1;
                else r = m - 1;
            } else {
                if (mountainArr.get(m) > target) l = m + 1;
                else r = m - 1;
            }
        }
        return -1;
    }

//    public static void main(String[] args) {
//        Task175 task = new Task175();
//        System.out.println(task.findInMountainArray(3, new int[]{1,2,3,4,5,3,1})); // 2
//        System.out.println(task.findInMountainArray(3, new int[]{0,1,2,4,2,1})); // -1
//    }
}