package ZeroShot.gemini;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        int[] arr1_1 = {1, 3, 5, 7};
        int[] arr2_1 = {2, 4, 6, 8};
        System.out.println(Arrays.toString(mergeSortedArrays(arr1_1, arr2_1)));

        int[] arr1_2 = {1, 2, 3};
        int[] arr2_2 = {4, 5, 6};
        System.out.println(Arrays.toString(mergeSortedArrays(arr1_2, arr2_2)));


        int[] arr1_3 = {};
        int[] arr2_3 = {1, 2, 3};
        System.out.println(Arrays.toString(mergeSortedArrays(arr1_3, arr2_3)));

        int[] arr1_4 = {1, 2, 3};
        int[] arr2_4 = {};
        System.out.println(Arrays.toString(mergeSortedArrays(arr1_4, arr2_4)));

        int[] arr1_5 = {1, 3, 5};
        int[] arr2_5 = {2, 4, 6, 8, 10};
        System.out.println(Arrays.toString(mergeSortedArrays(arr1_5, arr2_5)));

    }
}