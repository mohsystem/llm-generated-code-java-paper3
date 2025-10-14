package ourMethodv2.gpt4o;
import java.util.Arrays;

public class Task144 {

    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] mergedArray = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                mergedArray[k++] = arr1[i++];
            } else {
                mergedArray[k++] = arr2[j++];
            }
        }

        while (i < arr1.length) {
            mergedArray[k++] = arr1[i++];
        }

        while (j < arr2.length) {
            mergedArray[k++] = arr2[j++];
        }

        return mergedArray;
    }

    public static void main(String[] args) {
        int[] test1 = {1, 3, 5};
        int[] test2 = {2, 4, 6};
        System.out.println(Arrays.toString(mergeSortedArrays(test1, test2))); // [1, 2, 3, 4, 5, 6]

        int[] test3 = {0, 10, 20};
        int[] test4 = {5, 15, 25};
        System.out.println(Arrays.toString(mergeSortedArrays(test3, test4))); // [0, 5, 10, 15, 20, 25]

        int[] test5 = {1, 2, 3};
        int[] test6 = {};
        System.out.println(Arrays.toString(mergeSortedArrays(test5, test6))); // [1, 2, 3]

        int[] test7 = {};
        int[] test8 = {4, 5, 6};
        System.out.println(Arrays.toString(mergeSortedArrays(test7, test8))); // [4, 5, 6]

        int[] test9 = {7, 8, 9};
        int[] test10 = {1, 2, 3};
        System.out.println(Arrays.toString(mergeSortedArrays(test9, test10))); // [1, 2, 3, 7, 8, 9]
    }
}