package Vanilla.codestral;
public class Task146 {
    public static int findMissingNumber(int[] arr) {
        int n = arr.length + 1;
        int sum = n * (n + 1) / 2;
        for (int num : arr) {
            sum -= num;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 5};
        int[] arr2 = {2, 3, 4, 5, 6, 8};
        int[] arr3 = {1, 2, 3, 4, 6, 7, 8};
        int[] arr4 = {1, 2, 3, 4, 5, 6, 8, 9, 10};
        int[] arr5 = {2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println(findMissingNumber(arr1)); // Output: 4
        System.out.println(findMissingNumber(arr2)); // Output: 1
        System.out.println(findMissingNumber(arr3)); // Output: 5
        System.out.println(findMissingNumber(arr4)); // Output: 7
        System.out.println(findMissingNumber(arr5)); // Output: 1
    }
}