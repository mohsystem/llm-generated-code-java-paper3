package Vanilla.gemini;
import java.util.Arrays;

class Task14 {
    public static int findEvenIndex(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int leftSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += arr[j];
            }
            int rightSum = 0;
            for (int j = i + 1; j < arr.length; j++) {
                rightSum += arr[j];
            }
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 3, 2, 1};
        int result1 = findEvenIndex(arr1);
        System.out.println(result1); // Output: 3

        int[] arr2 = {1, 100, 50, -51, 1, 1};
        int result2 = findEvenIndex(arr2);
        System.out.println(result2); // Output: 1

        int[] arr3 = {20, 10, -80, 10, 10, 15, 35};
        int result3 = findEvenIndex(arr3);
        System.out.println(result3); // Output: 0

        int[] arr4 = {1, 2, 3, 4, 5};
        int result4 = findEvenIndex(arr4);
        System.out.println(result4); // Output: -1

        int[] arr5 = {1};
        int result5 = findEvenIndex(arr5);
        System.out.println(result5); // Output: 0



    }
}