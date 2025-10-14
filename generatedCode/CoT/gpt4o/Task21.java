package CoT.openai;
import java.util.ArrayList;
import java.util.Arrays;

public class Task21 {

    public static int[] removeSmallest(int[] numbers) {
        if (numbers.length == 0) return new int[]{};
        
        int minIndex = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[minIndex]) {
                minIndex = i;
            }
        }
        
        int[] result = new int[numbers.length - 1];
        for (int i = 0, j = 0; i < numbers.length; i++) {
            if (i != minIndex) {
                result[j++] = numbers[i];
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[][] testCases = {
            {1, 2, 3, 4, 5},
            {5, 3, 2, 1, 4},
            {2, 2, 1, 2, 1},
            {},
            {1}
        };
        
        for (int[] testCase : testCases) {
            System.out.println(Arrays.toString(removeSmallest(testCase)));
        }
    }
}