package ourMethod.claude;

public class Task143 {
    public static int[] sortArray(int[] arr) {
        // Input validation
        if (arr == null) {
            return new int[0];
        }
        
        // Create copy to preserve original array
        int[] result = arr.clone();
        
        // Sort array using merge sort
        mergeSort(result, 0, result.length - 1);
        
        return result;
    }
    
    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Find middle point
            int mid = left + (right - left) / 2; // Prevents overflow
            
            // Sort first and second halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            
            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }
    
    private static void merge(int[] arr, int left, int mid, int right) {
        // Calculate sizes of subarrays
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        // Create temp arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        
        // Copy data to temp arrays
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }
        
        // Merge temp arrays
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
        
        // Copy remaining elements of leftArray if any
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        
        // Copy remaining elements of rightArray if any
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
    
    public static void main(String[] args) {
        // Test cases
        int[][] testCases = {
            {64, 34, 25, 12, 22, 11, 90},  // Normal case
            {},                             // Empty array
            {1},                            // Single element
            {5, 5, 5, 5, 5},               // All same elements
            {9, 8, 7, 6, 5, 4, 3, 2, 1}    // Reverse sorted
        };
        
        for (int i = 0; i < testCases.length; i++) {
            System.out.print("Test case " + (i + 1) + " - Original: ");
            printArray(testCases[i]);
            
            int[] sorted = sortArray(testCases[i]);
            
            System.out.print("Sorted: ");
            printArray(sorted);
            System.out.println();
        }
    }
    
    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
