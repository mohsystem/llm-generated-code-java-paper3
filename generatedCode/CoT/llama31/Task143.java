package CoT.llama31;
public class Task143 {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test cases
        int[][] testCases = {
            {5, 1, 4, 2, 8},
            {64, 34, 25, 12, 22, 11, 90},
            {-2, 45, 0, 11, -9},
            {20, 12, 10, 15, 2},
            {1, 3, 5, 7, 9}
        };

        for (int[] testCase : testCases) {
            bubbleSort(testCase);
            System.out.print("Sorted array: ");
            printArray(testCase);
        }
    }
}