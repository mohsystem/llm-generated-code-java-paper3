package CoT.llama31;
public class Task18 {
    public static int binaryArrayToInt(int[] binaryArray) {
        int result = 0;
        for (int i = 0; i < binaryArray.length; i++) {
            result = (result << 1) | binaryArray[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] testCases = {
            {0, 0, 0, 1},
            {0, 0, 1, 0},
            {0, 1, 0, 1},
            {1, 0, 0, 1},
            {0, 0, 1, 0},
            {0, 1, 1, 0},
            {1, 1, 1, 1},
            {1, 0, 1, 1}
        };

        for (int[] testCase : testCases) {
            System.out.println("Testing: " + java.util.Arrays.toString(testCase) + " ==> " + binaryArrayToInt(testCase));
        }
    }
}