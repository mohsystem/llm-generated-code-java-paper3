package CoT.openai;
import java.util.Arrays;

public class Task143 {
    public static int[] sortArray(int[] array) {
        if (array == null) {
            return new int[0];
        }
        int[] sortedArray = array.clone();
        Arrays.sort(sortedArray);
        return sortedArray;
    }

    public static void main(String[] args) {
        int[][] testCases = {
            {5, 2, 9, 1, 5, 6},
            {3, 0, -2, 10, 4},
            {},
            {1},
            {-1, -10, 2, 3, 0}
        };
        
        for (int[] testCase : testCases) {
            System.out.println(Arrays.toString(sortArray(testCase)));
        }
    }
}