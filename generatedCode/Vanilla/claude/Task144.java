package Vanilla.claude;

public class Task144 {
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] merged = new int[n1 + n2];
        
        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                merged[k++] = arr1[i++];
            } else {
                merged[k++] = arr2[j++];
            }
        }
        
        while (i < n1) {
            merged[k++] = arr1[i++];
        }
        
        while (j < n2) {
            merged[k++] = arr2[j++];
        }
        
        return merged;
    }
    
    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        int[] result = mergeSortedArrays(arr1, arr2);
        System.out.println("Test 1: " + java.util.Arrays.toString(result));
        
        // Test case 2
        arr1 = new int[]{1, 2, 3, 4};
        arr2 = new int[]{5, 6, 7, 8};
        result = mergeSortedArrays(arr1, arr2);
        System.out.println("Test 2: " + java.util.Arrays.toString(result));
        
        // Test case 3
        arr1 = new int[]{1, 3, 5, 7};
        arr2 = new int[]{2, 4};
        result = mergeSortedArrays(arr1, arr2);
        System.out.println("Test 3: " + java.util.Arrays.toString(result));
        
        // Test case 4
        arr1 = new int[]{};
        arr2 = new int[]{1, 2, 3};
        result = mergeSortedArrays(arr1, arr2);
        System.out.println("Test 4: " + java.util.Arrays.toString(result));
        
        // Test case 5
        arr1 = new int[]{1, 1, 2, 3};
        arr2 = new int[]{1, 2, 2, 4};
        result = mergeSortedArrays(arr1, arr2);
        System.out.println("Test 5: " + java.util.Arrays.toString(result));
    }
}
