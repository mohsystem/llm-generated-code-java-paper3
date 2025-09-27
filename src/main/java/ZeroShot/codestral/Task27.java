package ZeroShot.codestral;
public class Task27 {
    public static int findOutlier(int[] arr) {
        int oddCount = 0, evenCount = 0, oddNum = 0, evenNum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                evenCount++;
                evenNum = arr[i];
            } else {
                oddCount++;
                oddNum = arr[i];
            }
        }
        return oddCount == 1 ? oddNum : evenNum;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 4, 0, 100, 4, 11, 2602, 36};
        int[] arr2 = {160, 3, 1719, 19, 11, 13, -21};
        System.out.println(findOutlier(arr1)); // 11
        System.out.println(findOutlier(arr2)); // 160
    }
}