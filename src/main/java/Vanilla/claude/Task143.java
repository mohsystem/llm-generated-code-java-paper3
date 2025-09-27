package Vanilla.claude;

public class Task143 {
    public static int[] sortArray(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n-1; i++) {
            for(int j = 0; j < n-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
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
            {3},
            {1, 1, 1, 1},
            {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}
        };
        
        for(int i = 0; i < testCases.length; i++) {
            System.out.print("Test case " + (i+1) + " Before sorting: ");
            for(int num : testCases[i]) {
                System.out.print(num + " ");
            }
            int[] sorted = sortArray(testCases[i]);
            System.out.print("\\nAfter sorting: ");
            for(int num : sorted) {
                System.out.print(num + " ");
            }
            System.out.println("\\n");
        }
    }
}
