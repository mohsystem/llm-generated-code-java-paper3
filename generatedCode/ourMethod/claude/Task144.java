package ourMethod.claude;

public class Task144 {
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        // Input validation
        if (arr1 == null || arr2 == null) {
            return new int[0];
        }
        
        int[] result = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        
        // Merge arrays while comparing elements
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }
        
        // Copy remaining elements from arr1, if any
        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }
        
        // Copy remaining elements from arr2, if any
        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }
        
        return result;
    }

    public static void main(String[] args) {
        // Test cases
        int[] test1_1 = {1, 3, 5};
        int[] test1_2 = {2, 4, 6};
        int[] result1 = mergeSortedArrays(test1_1, test1_2);
        System.out.println("Test 1: " + java.util.Arrays.toString(result1));

        int[] test2_1 = {1, 2, 3, 4};
        int[] test2_2 = {5, 6, 7, 8};
        int[] result2 = mergeSortedArrays(test2_1, test2_2);
        System.out.println("Test 2: " + java.util.Arrays.toString(result2));

        int[] test3_1 = {};
        int[] test3_2 = {1, 2, 3};
        int[] result3 = mergeSortedArrays(test3_1, test3_2);
        System.out.println("Test 3: " + java.util.Arrays.toString(result3));

        int[] test4_1 = {1, 1, 1};
        int[] test4_2 = {1, 1, 1};
        int[] result4 = mergeSortedArrays(test4_1, test4_2);
        System.out.println("Test 4: " + java.util.Arrays.toString(result4));

        int[] test5_1 = null;
        int[] test5_2 = {1, 2, 3};
        int[] result5 = mergeSortedArrays(test5_1, test5_2);
        System.out.println("Test 5: " + java.util.Arrays.toString(result5));
    }
}
