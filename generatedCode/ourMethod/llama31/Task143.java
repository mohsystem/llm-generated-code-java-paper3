package ourMethod.llama31;
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
        int[] data1 = {20, 12, 10, 15, 2};
        int[] data2 = {64, 34, 25, 12, 22, 11, 90};
        int[] data3 = {-2, 45, 0, 11, -9};
        int[] data4 = {1, 1, 1, 1, 1};
        int[] data5 = {5, 4, 3, 2, 1};

        selectionSort(data1);
        System.out.println("Sorted Array 1: ");
        printArray(data1);

        selectionSort(data2);
        System.out.println("Sorted Array 2: ");
        printArray(data2);

        selectionSort(data3);
        System.out.println("Sorted Array 3: ");
        printArray(data3);

        selectionSort(data4);
        System.out.println("Sorted Array 4: ");
        printArray(data4);

        selectionSort(data5);
        System.out.println("Sorted Array 5: ");
        printArray(data5);
    }
}