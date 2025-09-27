package ourMethod.gemini;
import java.util.Arrays;

class Task144 {
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] mergedArr = new int[n1 + n2];

        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                mergedArr[k++] = arr1[i++];
            } else {
                mergedArr[k++] = arr2[j++];
            }
        }

        while (i < n1) {
            mergedArr[k++] = arr1[i++];
        }

        while (j < n2) {
            mergedArr[k++] = arr2[j++];
        }

        return mergedArr;
    }


}