package CoT.llama31;
public class Task155 {
    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Extract elements one by one
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    public static void printArray(int[] arr) {
        for (int j = 0; j < arr.length; j++)
            System.out.print(arr[j] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = {12, 11, 31, 3, 5, 7, 9};
        int[] arr2 = {4, 10, 3, 8, 1};
        int[] arr3 = {20, 12, 10, 3, 4};
        int[] arr4 = {5, 2, 8, 1, 9};
        int[] arr5 = {6, 3, 1, 8, 4, 2};

        heapSort(arr1);
        heapSort(arr2);
        heapSort(arr3);
        heapSort(arr4);
        heapSort(arr5);

        System.out.println("Sorted array 1: ");
        printArray(arr1);
        System.out.println("Sorted array 2: ");
        printArray(arr2);
        System.out.println("Sorted array 3: ");
        printArray(arr3);
        System.out.println("Sorted array 4: ");
        printArray(arr4);
        System.out.println("Sorted array 5: ");
        printArray(arr5);
    }
}