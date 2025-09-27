package CoT.llama31;
public class Task147 {
    public static void main(String[] args) {
        int[][] testCases = {
            {3, 2, 1, 5, 6, 4}, 2,
            {1, 2, 3, 4, 5}, 3,
            {10, 20, 30, 40, 50}, 1,
            {5, 5, 5, 5, 5}, 2,
            {1}, 1
        };

        for (int i = 0; i < testCases.length; i += 2) {
            int[] array = new int[testCases[i].length - 1];
            System.arraycopy(testCases[i], 0, array, 0, array.length);
            int k = testCases[i][array.length];
            System.out.println("Array: " + java.util.Arrays.toString(array) + ", k: " + k);
            System.out.println("Kth largest element: " + findKthLargest(array, k));
            System.out.println();
        }
    }

    public static int findKthLargest(int[] array, int k) {
        // Sort the array in descending order
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array[k - 1];
    }
}