package ourMethod.llama31;
public class Task166 {
    public static void main(String[] args) {
        int[][] testCases = {
            {6, 3, -2, 5, -8, 2, -2},
            {6, 5, 4, -1, 3, 2, -1, 1},
            {-5, -5, -5, -5, 7, -5},
            {}
        };

        for (int[] testCase : testCases) {
            int[] sortedArray = posNegSort(testCase);
            for (int num : sortedArray) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static int[] posNegSort(int[] arr) {
        int[] positives = new int[arr.length];
        int posCount = 0;
        int[] negatives = new int[arr.length];
        int negCount = 0;

        // Separate positive and negative numbers
        for (int num : arr) {
            if (num > 0) {
                positives[posCount++] = num;
            } else {
                negatives[negCount++] = num;
            }
        }

        // Sort the positive numbers
        java.util.Arrays.sort(positives, 0, posCount);

        // Combine the sorted positives and negatives
        int[] result = new int[arr.length];
        int j = 0, k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                result[i] = positives[j++];
            } else {
                result[i] = negatives[k++];
            }
        }

        return result;
    }
}