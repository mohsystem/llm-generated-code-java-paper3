package CoT.claude;

public class Task143 {
    public static int[] sortArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        
        int n = arr.length;
        int temp;
        
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
    
    public static void main(String[] args) {
        // Test cases
        int[][] testCases = {
            {64, 34, 25, 12, 22, 11, 90},
            {5, 2, 8, 1, 9},
            {1},
            {},
            {10, 10, 10, 10}
        };
        
        for (int i = 0; i < testCases.length; i++) {
            System.out.print("Test case " + (i+1) + " Input: ");
            for (int num : testCases[i]) {
                System.out.print(num + " ");
            }
            System.out.println();
            
            int[] result = sortArray(testCases[i]);
            System.out.print("Sorted array: ");
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println("\n");
        }
    }
}
