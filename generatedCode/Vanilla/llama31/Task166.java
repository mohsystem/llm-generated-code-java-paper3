package Vanilla.llama31;
public class Task166 {
    public static void main(String[] args) {
        int[][] testCases = {
            {6, 3, -2, 5, -8, 2, -2},
            {6, 5, 4, -1, 3, 2, -1, 1},
            {-5, -5, -5, -5, 7, -5},
            {}
        };

        for (int[] testCase : testCases) {
            int[] result = posNegSort(testCase);
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static int[] posNegSort(int[] arr) {
        int[] positives = new int[arr.length];
        int positiveCount = 0;

        // Store all positive numbers
        for (int num : arr) {
            if (num > 0) {
                positives[positiveCount++] = num;
            }
        }

        // Sort the positive numbers
        java.util.Arrays.sort(positives, 0, positiveCount);

        int j = 0;
        int[] sorted = new int[arr.length];

        // Replace positive numbers with sorted positives
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                sorted[i] = positives[j++];
            } else {
                sorted[i] = arr[i];
            }
        }

        return sorted;
    }
}