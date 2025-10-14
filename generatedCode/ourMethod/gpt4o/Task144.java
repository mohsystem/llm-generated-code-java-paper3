package ourMethod.openai;
public class Task144 {
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] mergedArray = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
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
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        int[] arr3 = {10, 20, 30};
        int[] arr4 = {5, 15, 25};
        int[] arr5 = {100, 200};
        int[] arr6 = {50, 150};

        // Test cases
        int[] result1 = mergeSortedArrays(arr1, arr2);
        int[] result2 = mergeSortedArrays(arr3, arr4);
        int[] result3 = mergeSortedArrays(arr5, arr6);
        int[] result4 = mergeSortedArrays(arr1, arr3);
        int[] result5 = mergeSortedArrays(arr4, arr6);

        // Output results
        for (int num : result1) System.out.print(num + " ");
        System.out.println();
        for (int num : result2) System.out.print(num + " ");
        System.out.println();
        for (int num : result3) System.out.print(num + " ");
        System.out.println();
        for (int num : result4) System.out.print(num + " ");
        System.out.println();
        for (int num : result5) System.out.print(num + " ");
    }
}