package Vanilla.gemini;
import java.util.Arrays;

class Task144 {
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] mergedArray = new int[n1 + n2];

        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                mergedArray[k++] = arr1[i++];
            } else {
                mergedArray[k++] = arr2[j++];
            }
        }

        while (i < n1) {
            mergedArray[k++] = arr1[i++];
        }

        while (j < n2) {
            mergedArray[k++] = arr2[j++];
        }

        return mergedArray;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};
        System.out.println(Arrays.toString(mergeSortedArrays(arr1, arr2)));

        arr1 = {1, 2, 3};
        arr2 = {4, 5, 6};
        System.out.println(Arrays.toString(mergeSortedArrays(arr1, arr2)));

        arr1 = {};
        arr2 = {1, 2, 3};
        System.out.println(Arrays.toString(mergeSortedArrays(arr1, arr2)));

        arr1 = {1, 2, 3};
        arr2 = {};
        System.out.println(Arrays.toString(mergeSortedArrays(arr1, arr2)));

        arr1 = {1, 3, 5};
        arr2 = {2, 4, 6, 8, 10};
        System.out.println(Arrays.toString(mergeSortedArrays(arr1, arr2)));


    }
}