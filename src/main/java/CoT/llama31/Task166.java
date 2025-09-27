package CoT.llama31;
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
        // Separate positive and negative numbers
        int[] positives = new int[arr.length];
        int[] negatives = new int[arr.length];
        int posIndex = 0, negIndex = 0;

        for (int num : arr) {
            if (num > 0) {
                positives[posIndex++] = num;
            } else {
                negatives[negIndex++] = num;
            }
        }

        // Sort the positive numbers
        int[] sortedPositives = new int[posIndex];
        System.arraycopy(positives, 0, sortedPositives, 0, posIndex);
        sortArray(sortedPositives, 0, posIndex - 1);

        // Combine the sorted positives and negatives
        int[] result = new int[arr.length];
        int i = 0, j = 0, k = 0;
        while (i < posIndex || j < negIndex) {
            if (i < posIndex && (j == negIndex || sortedPositives[i] <= negatives[j])) {
                result[k++] = sortedPositives[i++];
            } else {
                result[k++] = negatives[j++];
            }
        }

        return result;
    }

    public static void sortArray(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            sortArray(arr, low, pi - 1);
            sortArray(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}