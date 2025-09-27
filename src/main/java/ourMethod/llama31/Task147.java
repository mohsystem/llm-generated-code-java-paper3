package ourMethod.llama31;
public class Task147 {
    public static void main(String[] args) {
        int[][] testCases = {
            {5, 2, 8, 12, 3},
            {10, 20, 30, 40, 50},
            {100, 200, 300, 400, 500},
            {5, 5, 5, 5, 5},
            {1, 2, 3, 4, 5}
        };
        int[] kValues = {2, 3, 4, 1, 3};

        for (int i = 0; i < testCases.length; i++) {
            int[] array = testCases[i];
            int k = kValues[i];
            System.out.println("Array: " + java.util.Arrays.toString(array) + ", k: " + k);
            System.out.println("Kth largest element: " + findKthLargest(array, k));
            System.out.println();
        }
    }

    public static int findKthLargest(int[] array, int k) {
        if (k < 1 || k > array.length) {
            throw new IllegalArgumentException("k is out of range");
        }

        // Sort the array in descending order
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    // Swap elements
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        return array[k - 1];
    }
}