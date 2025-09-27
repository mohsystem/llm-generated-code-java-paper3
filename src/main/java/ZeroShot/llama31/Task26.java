package ZeroShot.llama31;
public class Task26 {
    public static int findOddOccurrence(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = res ^ arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] testCases = {
            {7},
            {0},
            {1, 1, 2},
            {0, 1, 0, 1, 0},
            {1, 2, 2, 3, 3, 3, 4, 3, 3, 3, 2, 2, 1}
        };

        for (int[] testCase : testCases) {
            System.out.println("Input: " + java.util.Arrays.toString(testCase));
            System.out.println("Output: " + findOddOccurrence(testCase));
            System.out.println();
        }
    }
}