package ZeroShot.gemini;
import java.util.Arrays;

class Task14 {
    public static int findEvenIndex(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int leftSum = 0;
            int rightSum = 0;

            for (int j = 0; j < i; j++) {
                leftSum += arr[j];
            }

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
        int[] arr2 = {1, 100, 50, -51, 1, 1};
        int[] arr3 = {20, 10, -80, 10, 10, 15, 35};
        int[] arr4 = {1, 2, 3, 4, 5};
        int[] arr5 = {10, -80, 10, 10, 15, 35, 20};


        System.out.println(findEvenIndex(arr1)); // Output: 3
        System.out.println(findEvenIndex(arr2)); // Output: 1
        System.out.println(findEvenIndex(arr3)); // Output: 0
        System.out.println(findEvenIndex(arr4)); // Output: -1
        System.out.println(findEvenIndex(arr5)); // Output: 6

    }
}