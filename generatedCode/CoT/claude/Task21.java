package CoT.claude;

public class Task21 {
    public static int[] removeSmallest(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return new int[]{};
        }
        
        int[] result = new int[numbers.length - 1];
        int minIndex = 0;
        
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[minIndex]) {
                minIndex = i;
            }
        }
        
        for (int i = 0, j = 0; i < numbers.length; i++) {
            if (i != minIndex) {
                result[j++] = numbers[i];
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        // Test cases
        int[][] testCases = {
            {1, 2, 3, 4, 5},
            {5, 3, 2, 1, 4},
            {2, 2, 1, 2, 1},
            {1},
            {}
        };
        
        for (int[] test : testCases) {
            System.out.print("Input: ");
            printArray(test);
            System.out.print("Output: ");
            printArray(removeSmallest(test));
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
