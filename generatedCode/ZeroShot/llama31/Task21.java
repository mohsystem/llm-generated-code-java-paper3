package ZeroShot.llama31;
public class Task21 {
    public static int[] removeSmallest(int[] ratings) {
        if (ratings.length == 0) {
            return new int[0];
        }
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

    public static void main(String[] args) {
        int[] testCases[] = {
            {1, 2, 3, 4, 5},
            {5, 3, 2, 1, 4},
            {2, 2, 1, 2, 1},
            {},
            {1}
        };
        for (int[] testCase : testCases) {
            int[] result = removeSmallest(testCase);
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}