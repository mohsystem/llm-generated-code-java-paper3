package Vanilla.llama31;
public class Task143 {
    public static void selectionSort(int[] array) {
        int size = array.length;
        for (int step = 0; step < size - 1; step++) {
            int min_idx = step;
            for (int i = step + 1; i < size; i++) {
                if (array[i] < array[min_idx]) {
                    min_idx = i;
                }
            }
            // Swap the found minimum element with the first element of the unsorted part
            int temp = array[step];
            array[step] = array[min_idx];
            array[min_idx] = temp;
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] testCases = {
            {-2, 45, 0, 11, -9},
            {5, 2, 8, 7, 1},
            {10, 9, 8, 7, 6},
            {1, 2, 3, 4, 5},
            {5, 4, 3, 2, 1}
        };

        for (int[] testCase : testCases) {
            selectionSort(testCase);
            System.out.print("Sorted Array: ");
            printArray(testCase);
        }
    }
}