package ZeroShot.llama31;
public class Task143 {
    public static void sortArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            // Swap the found minimum element with the first element of the unsorted part
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] testCases = {
            {20, 12, 10, 15, 2},
            {5, 4, 3, 2, 1},
            {1, 2, 3, 4, 5},
            {-2, 45, 0, 11, -9},
            {64, 34, 25, 12, 22, 11, 90}
        };

        for (int[] testCase : testCases) {
            sortArray(testCase);
            System.out.print("Sorted Array: ");
            printArray(testCase);
        }
    }
}