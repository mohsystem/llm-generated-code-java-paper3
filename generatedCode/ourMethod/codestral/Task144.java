package ourMethod.codestral;
import java.util.Arrays;

public class Task144 {
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] mergedArray = new int[arr1.length + arr2.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                mergedArray[k] = arr1[i];
                i++;
            } else {
                mergedArray[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < arr1.length) {
            mergedArray[k] = arr1[i];
            i++;
            k++;
        }

        while (j < arr2.length) {
            mergedArray[k] = arr2[j];
            j++;
            k++;
        }

        return mergedArray;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};
        int[] mergedArray = mergeSortedArrays(arr1, arr2);
        System.out.println(Arrays.toString(mergedArray));

        int[] arr3 = {1, 3, 5};
        int[] arr4 = {2, 4, 6, 8, 10};
        mergedArray = mergeSortedArrays(arr3, arr4);
        System.out.println(Arrays.toString(mergedArray));

        int[] arr5 = {1, 2, 3};
        int[] arr6 = {4, 5, 6};
        mergedArray = mergeSortedArrays(arr5, arr6);
        System.out.println(Arrays.toString(mergedArray));

        int[] arr7 = {};
        int[] arr8 = {1, 2, 3};
        mergedArray = mergeSortedArrays(arr7, arr8);
        System.out.println(Arrays.toString(mergedArray));

        int[] arr9 = {1, 2, 3};
        int[] arr10 = {};
        mergedArray = mergeSortedArrays(arr9, arr10);
        System.out.println(Arrays.toString(mergedArray));
    }
}