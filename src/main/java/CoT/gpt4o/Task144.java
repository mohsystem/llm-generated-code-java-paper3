package CoT.gpt4o;
public class Task144 {

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
        int[] result1 = mergeSortedArrays(new int[]{1, 3, 5}, new int[]{2, 4, 6});
        int[] result2 = mergeSortedArrays(new int[]{}, new int[]{1, 2, 3});
        int[] result3 = mergeSortedArrays(new int[]{1, 2, 3}, new int[]{});
        int[] result4 = mergeSortedArrays(new int[]{1, 3, 5, 7}, new int[]{2, 4, 6, 8});
        int[] result5 = mergeSortedArrays(new int[]{1}, new int[]{2});

        // Print test results
        for (int[] result : new int[][]{result1, result2, result3, result4, result5}) {
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}