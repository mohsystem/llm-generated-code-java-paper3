package ourMethod.llama31;
public class Task18 {
    public static int binaryArrayToInt(int[] binaryArray) {
        String binaryString = "";
        for (int i : binaryArray) {
            binaryString += i;
        }
        return Integer.parseInt(binaryString, 2);
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