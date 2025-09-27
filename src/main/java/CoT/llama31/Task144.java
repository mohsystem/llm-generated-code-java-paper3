package CoT.llama31;
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
        // Copy remaining elements of arr1, if any
        while (i < arr1.length) {
            arr3[k++] = arr1[i++];
        }
        // Copy remaining elements of arr2, if any
        while (j < arr2.length) {
            arr3[k++] = arr2[j++];
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};
        int[] arr3 = new int[arr1.length + arr2.length];
        mergeArrays(arr1, arr2, arr3);
        for (int value : arr3) {
            System.out.print(value + " ");
        }
        System.out.println();

        // Test case 2
        arr1 = new int[] {5, 8, 9};
        arr2 = new int[] {4, 7, 8};
        arr3 = new int[arr1.length + arr2.length];
        mergeArrays(arr1, arr2, arr3);
        for (int value : arr3) {
            System.out.print(value + " ");
        }
        System.out.println();

        // Test case 3
        arr1 = new int[] {1, 3};
        arr2 = new int[] {2, 4, 6};
        arr3 = new int[arr1.length + arr2.length];
        mergeArrays(arr1, arr2, arr3);
        for (int value : arr3) {
            System.out.print(value + " ");
        }
        System.out.println();

        // Test case 4
        arr1 = new int[] {1, 3, 5};
        arr2 = new int[] {};
        arr3 = new int[arr1.length + arr2.length];
        mergeArrays(arr1, arr2, arr3);
        for (int value : arr3) {
            System.out.print(value + " ");
        }
        System.out.println();

        // Test case 5
        arr1 = new int[] {};
        arr2 = new int[] {2, 4, 6};
        arr3 = new int[arr1.length + arr2.length];
        mergeArrays(arr1, arr2, arr3);
        for (int value : arr3) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}