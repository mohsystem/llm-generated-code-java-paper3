package Vanilla.openai;
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
        int[] result1 = mergeSortedArrays(new int[]{1, 3, 5}, new int[]{2, 4, 6});
        int[] result2 = mergeSortedArrays(new int[]{}, new int[]{1, 2, 3});
        int[] result3 = mergeSortedArrays(new int[]{1, 2, 3}, new int[]{});
        int[] result4 = mergeSortedArrays(new int[]{1, 3, 5}, new int[]{7, 9});
        int[] result5 = mergeSortedArrays(new int[]{}, new int[]{});

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