package Vanilla.llama31;
public class Task26 {
    public static int findOddOccurrence(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count % 2 != 0) {
                return arr[i];
            }
        }
        return -1; // This line should not be reached based on the problem statement
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
            System.out.println(findOddOccurrence(testCase));
        }
    }
}