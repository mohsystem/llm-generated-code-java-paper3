package ZeroShot.openai;
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
        int[][] testCases = {
            {1, 3, 5, 7}, {2, 4, 6, 8},
            {}, {1, 2, 3},
            {1, 1, 1}, {2, 2, 2},
            {1, 2, 3}, {},
            {}, {}
        };
        
        for (int i = 0; i < testCases.length; i += 2) {
            int[] merged = mergeSortedArrays(testCases[i], testCases[i + 1]);
            System.out.println(java.util.Arrays.toString(merged));
        }
    }
}