package Vanilla.openai;
public class Task18 {
    public static int binaryArrayToInt(int[] binaryArray) {
        int result = 0;
        for (int i = 0; i < binaryArray.length; i++) {
            result = result * 2 + binaryArray[i];
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[][] testCases = {
            {0, 0, 0, 1},
            {0, 0, 1, 0},
            {0, 1, 0, 1},
            {1, 0, 0, 1},
            {0, 1, 1, 0}
        };
        
        for (int[] testCase : testCases) {
            System.out.println(binaryArrayToInt(testCase));
        }
    }
}