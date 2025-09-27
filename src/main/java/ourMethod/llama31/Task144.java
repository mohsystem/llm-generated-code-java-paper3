package ourMethod.llama31;
public class Task144 {
    public static void mergeArrays(int[] arr1, int[] arr2, int[] result) {
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }
        // Copy remaining elements of arr1, if any
        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }
        // Copy remaining elements of arr2, if any
        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {11, 15, 17};
        int[] arr2 = {2, 5, 8};
        int[] result = new int[arr1.length + arr2.length];
        mergeArrays(arr1, arr2, result);
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Test cases
        int[] arr3 = {1, 3, 5};
        int[] arr4 = {2, 4, 6};
        int[] result2 = new int[arr3.length + arr4.length];
        mergeArrays(arr3, arr4, result2);
        for (int i : result2) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] arr5 = {10, 20, 30};
        int[] arr6 = {5, 15, 25};
        int[] result3 = new int[arr5.length + arr6.length];
        mergeArrays(arr5, arr6, result3);
        for (int i : result3) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] arr7 = {1, 3};
        int[] arr8 = {2, 4, 6};
        int[] result4 = new int[arr7.length + arr8.length];
        mergeArrays(arr7, arr8, result4);
        for (int i : result4) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] arr9 = {1, 3, 5};
        int[] arr10 = {2};
        int[] result5 = new int[arr9.length + arr10.length];
        mergeArrays(arr9, arr10, result5);
        for (int i : result5) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}