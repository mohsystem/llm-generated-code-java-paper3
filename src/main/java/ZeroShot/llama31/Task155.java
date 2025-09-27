package ZeroShot.llama31;
public class Task155 {
    public static void heapify(int arr[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }

    public static void heapSort(int arr[]) {
        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Heap sort
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = {9, 4, 3, 8, 10, 2, 5};
        int[] arr2 = {1, 2, 3, 4, 5};
        int[] arr3 = {5, 4, 3, 2, 1};
        int[] arr4 = {1, 1, 1, 1, 1};
        int[] arr5 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        heapSort(arr1);
        heapSort(arr2);
        heapSort(arr3);
        heapSort(arr4);
        heapSort(arr5);

        printArray(arr1);
        printArray(arr2);
        printArray(arr3);
        printArray(arr4);
        printArray(arr5);
    }
}