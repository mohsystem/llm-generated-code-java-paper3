package CoT.llama31;
// Java code
public class Task21 {
    public static void main(String[] args) {
        int[][] testCases = {
            {1, 2, 3, 4, 5},
            {5, 3, 2, 1, 4},
            {2, 2, 1, 2, 1},
            {},
            {10}
        };

        for (int[] testCase : testCases) {
            int[] result = removeSmallest(testCase);
            printArray(result);
        }
    }

    public static int[] removeSmallest(int[] ratings) {
        if (ratings.length == 0) return new int[0];

        int minIndex = 0;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] < ratings[minIndex]) {
                minIndex = i;
            }
        }

        int[] result = new int[ratings.length - 1];
        System.arraycopy(ratings, 0, result, 0, minIndex);
        System.arraycopy(ratings, minIndex + 1, result, minIndex, ratings.length - minIndex - 1);
        return result;
    }

    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}