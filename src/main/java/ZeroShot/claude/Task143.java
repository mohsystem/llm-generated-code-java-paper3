package ZeroShot.claude;

public class Task143 {
    public static int[] sortArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
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
            {1, 1, 1, 1},
            {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}
        };
        
        for(int i = 0; i < testCases.length; i++) {
            System.out.print("Test case " + (i+1) + " Before sorting: ");
            for(int num : testCases[i]) {
                System.out.print(num + " ");
            }
            System.out.println();
            
            int[] sorted = sortArray(testCases[i].clone());
            
            System.out.print("After sorting: ");
            for(int num : sorted) {
                System.out.print(num + " ");
            }
            System.out.println("\\n");
        }
    }
}
