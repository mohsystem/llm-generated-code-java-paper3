package Vanilla.llama31;
public class Task144 {
    public static void mergeArrays(int[] arr1, int[] arr2, int[] arr3) {
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                arr3[k++] = arr1[i++];
            } else {
                arr3[k++] = arr2[j++];
            }
        }
        // Copy remaining elements from arr1, if any
        while (i < arr1.length) {
            arr3[k++] = arr1[i++];
        }
        // Copy remaining elements from arr2, if any
        while (j < arr2.length) {
            arr3[k++] = arr2[j++];
        }
    }

    public static void main(String[] args) {
        // Test cases
        int[][] testCases = {
            {1, 3, 4, 5},
            {2, 4, 6, 8},
            {5, 8, 9},
            {4, 7, 8},
            {1, 2},
            {3, 4},
            {1},
            {2, 3},
            {1, 2, 3},
            {4, 5, 6}
        };

        for (int i = 0; i < testCases.length; i += 2) {
            int[] arr1 = testCases[i];
            int[] arr2 = testCases[i + 1];
            int[] arr3 = new int[arr1.length + arr2.length];
            mergeArrays(arr1, arr2, arr3);
            System.out.print("Array 1: ");
            for (int num : arr1) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.print("Array 2: ");
            for (int num : arr2) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.print("Merged Array: ");
            for (int num : arr3) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println();
        }
    }
}