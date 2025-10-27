package ourMethod.claude;

public class Task155 {
    public static void heapSort(int[] arr) {
        int n = arr.length;
        
        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
            
        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            
            // Call heapify on reduced heap
            heapify(arr, i, 0);
        }
    }
    
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        // Compare with left child
        if (left < n && arr[left] > arr[largest])
            largest = left;
            
        // Compare with right child    
        if (right < n && arr[right] > arr[largest])
            largest = right;
            
        // If largest is not root
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            
            // Recursively heapify affected sub-tree
            heapify(arr, n, largest);
        }
    }
    
    public static void main(String[] args) {
        // Test cases
        int[][] testCases = {
            {4, 10, 3, 5, 1},
            {64, 34, 25, 12, 22, 11, 90},
            {1},
            {1, 2, 3, 4, 5},
            {5, 4, 3, 2, 1}
        };
        
        for(int i = 0; i < testCases.length; i++) {
            System.out.print("Test case " + (i+1) + " Before sorting: ");
            for(int num : testCases[i])
                System.out.print(num + " ");
                
            heapSort(testCases[i]);
            
            System.out.print("\\nTest case " + (i+1) + " After sorting: ");
            for(int num : testCases[i])
                System.out.print(num + " ");
            System.out.println("\n");
        }
    }
}
