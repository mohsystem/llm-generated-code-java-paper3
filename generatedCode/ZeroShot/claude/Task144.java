package ZeroShot.claude;

public class Task144 {
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
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
        // Test case 1
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        int[] result = mergeSortedArrays(arr1, arr2);
        for(int num : result) System.out.print(num + " ");
        System.out.println();
        
        // Test case 2
        arr1 = new int[]{1, 2, 3, 4};
        arr2 = new int[]{5, 6, 7, 8};
        result = mergeSortedArrays(arr1, arr2);
        for(int num : result) System.out.print(num + " ");
        System.out.println();
        
        // Test case 3
        arr1 = new int[]{1, 3, 5, 7};
        arr2 = new int[]{2, 4};
        result = mergeSortedArrays(arr1, arr2);
        for(int num : result) System.out.print(num + " ");
        System.out.println();
        
        // Test case 4
        arr1 = new int[]{};
        arr2 = new int[]{1, 2, 3};
        result = mergeSortedArrays(arr1, arr2);
        for(int num : result) System.out.print(num + " ");
        System.out.println();
        
        // Test case 5
        arr1 = new int[]{1, 1, 2, 3};
        arr2 = new int[]{1, 2, 2};
        result = mergeSortedArrays(arr1, arr2);
        for(int num : result) System.out.print(num + " ");
        System.out.println();
    }
}
