package CoT.claude;

public class Task144 {
    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) {
            return null;
        }
        
        int[] merged = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                merged[k++] = arr1[i++];
            } else {
                merged[k++] = arr2[j++];
            }
        }
        
        while (i < arr1.length) {
            merged[k++] = arr1[i++];
        }
        
        while (j < arr2.length) {
            merged[k++] = arr2[j++];
        }
        
        return merged;
    }
    
    public static void main(String[] args) {
        // Test case 1: Regular sorted arrays
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        int[] result = mergeArrays(arr1, arr2);
        for(int num : result) System.out.print(num + " ");
        System.out.println();
        
        // Test case 2: One empty array
        int[] arr3 = {};
        int[] arr4 = {1, 2, 3};
        result = mergeArrays(arr3, arr4);
        for(int num : result) System.out.print(num + " ");
        System.out.println();
        
        // Test case 3: Arrays with duplicate elements
        int[] arr5 = {1, 2, 2};
        int[] arr6 = {2, 3, 3};
        result = mergeArrays(arr5, arr6);
        for(int num : result) System.out.print(num + " ");
        System.out.println();
        
        // Test case 4: Arrays of different lengths
        int[] arr7 = {1, 2, 3, 4};
        int[] arr8 = {5, 6};
        result = mergeArrays(arr7, arr8);
        for(int num : result) System.out.print(num + " ");
        System.out.println();
        
        // Test case 5: Null arrays
        result = mergeArrays(null, null);
        if(result == null) System.out.println("Null input handled");
    }
}
