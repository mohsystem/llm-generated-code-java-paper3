package CoT.gpt4o;
public class Task155 {
    public static void heapSort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
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

    public static void main(String[] args) {
        int[][] testCases = {
            {12, 11, 13, 5, 6, 7},
            {4, 10, 3, 5, 1},
            {1, 3, 9, 4, 2},
            {10, 15, 20, 5, 25},
            {3, 6, 9, 12, 15}
        };

        for (int[] testCase : testCases) {
            heapSort(testCase);
            for (int num : testCase) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}