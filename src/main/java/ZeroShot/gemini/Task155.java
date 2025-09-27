package ZeroShot.gemini;
import java.util.Arrays;

class Task155 {

    public int[] heapSort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
        return arr;
    }

    private void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        Task155 hs = new Task155();
        int[] arr1 = {5, 1, 4, 2, 8};
        System.out.println(Arrays.toString(hs.heapSort(arr1.clone())));

        int[] arr2 = {12, 11, 13, 5, 6, 7};
        System.out.println(Arrays.toString(hs.heapSort(arr2.clone())));

        int[] arr3 = {};
        System.out.println(Arrays.toString(hs.heapSort(arr3.clone())));
        
        int[] arr4 = {5};
        System.out.println(Arrays.toString(hs.heapSort(arr4.clone())));

        int[] arr5 = {5, 1};
        System.out.println(Arrays.toString(hs.heapSort(arr5.clone())));
    }
}