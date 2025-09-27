package Vanilla.llama31;
public class Task21 {
    public static void main(String[] args) {
        int[][] testCases = {
            {1, 2, 3, 4, 5},
            {5, 3, 2, 1, 4},
            {2, 2, 1, 2, 1},
            {},
            {10}
        };

        for (int[] testCase : testCases) {
            int[] result = removeSmallest(testCase);
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static int[] removeSmallest(int[] arr) {
        if (arr.length == 0) {
            return new int[0];
        }

        int minIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }

        int[] result = new int[arr.length - 1];
        System.arraycopy(arr, 0, result, 0, minIndex);
        System.arraycopy(arr, minIndex + 1, result, minIndex, arr.length - minIndex - 1);

        return result;
    }
}