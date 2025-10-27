package CoT.claude;

public class Task155 {
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        
        int n = arr.length;
        
        // Build max heap
        for (int i = n/2 - 1; i >= 0; i--)
            heapify(arr, n, i);
            
        // Extract elements from heap one by one    
        for (int i = n-1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            
            heapify(arr, i, 0);
        }
    }
    
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;
        
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
        // Test cases
        int[][] testCases = {
            {64, 34, 25, 12, 22, 11, 90},
            {5, 2, 8, 1, 9, 3},
            {1},
            {1, 2, 3, 4, 5},
            {5, 4, 3, 2, 1}
        };
        
        for(int i = 0; i < testCases.length; i++) {
            System.out.print("Test case " + (i+1) + " Before sorting: ");
            for(int num : testCases[i])
                System.out.print(num + " ");
            
            heapSort(testCases[i]);
            
            System.out.print("\\nAfter sorting: ");
            for(int num : testCases[i])
                System.out.print(num + " ");
            System.out.println("\n");
        }
    }
}
