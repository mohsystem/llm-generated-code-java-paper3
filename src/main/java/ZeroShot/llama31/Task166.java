package ZeroShot.llama31;
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
        int[] positiveNumbers = new int[arr.length];
        int positiveCount = 0;
        int[] result = new int[arr.length];

        // Separate positive numbers
        for (int num : arr) {
            if (num > 0) {
                positiveNumbers[positiveCount++] = num;
            }
        }

        // Sort positive numbers
        for (int i = 0; i < positiveCount - 1; i++) {
            for (int j = i + 1; j < positiveCount; j++) {
                if (positiveNumbers[i] > positiveNumbers[j]) {
                    int temp = positiveNumbers[i];
                    positiveNumbers[i] = positiveNumbers[j];
                    positiveNumbers[j] = temp;
                }
            }
        }

        // Reconstruct the array
        int posIndex = 0;
        int negIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                result[i] = positiveNumbers[posIndex++];
            } else {
                while (negIndex < arr.length && arr[negIndex] > 0) {
                    negIndex++;
                }
                result[i] = arr[negIndex++];
            }
        }

        return result;
    }
}