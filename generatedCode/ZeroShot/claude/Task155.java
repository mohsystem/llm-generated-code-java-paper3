package ZeroShot.claude;

class Task155 {
    public void heapSort(int[] arr) {
        int n = arr.length;
        
        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
            
        // Extract elements from heap one by one    
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            
            heapify(arr, i, 0);
        }
    }
    
    private void heapify(int[] arr, int n, int i) {
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
        Task155 task = new Task155();
        
        // Test case 1: Random array
        int[] arr1 = {12, 11, 13, 5, 6, 7};
        task.heapSort(arr1);
        System.out.println("Test 1: " + java.util.Arrays.toString(arr1));
        
        // Test case 2: Already sorted array
        int[] arr2 = {1, 2, 3, 4, 5};
        task.heapSort(arr2);
        System.out.println("Test 2: " + java.util.Arrays.toString(arr2));
        
        // Test case 3: Reverse sorted array
        int[] arr3 = {5, 4, 3, 2, 1};
        task.heapSort(arr3);
        System.out.println("Test 3: " + java.util.Arrays.toString(arr3));
        
        // Test case 4: Array with duplicates
        int[] arr4 = {4, 4, 2, 2, 3, 3, 1, 1};
        task.heapSort(arr4);
        System.out.println("Test 4: " + java.util.Arrays.toString(arr4));
        
        // Test case 5: Single element array
        int[] arr5 = {1};
        task.heapSort(arr5);
        System.out.println("Test 5: " + java.util.Arrays.toString(arr5));
    }
}
