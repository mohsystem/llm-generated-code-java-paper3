package ZeroShot.claude;

public class Task18 {
    public static int binaryArrayToNumber(int[] binary) {
        int result = 0;
        for(int bit : binary) {
            result = result * 2 + bit;
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[][] testCases = {
            {0, 0, 0, 1},
            {0, 0, 1, 0},
            {0, 1, 0, 1},
            {1, 0, 0, 1},
            {1, 1, 1, 1}
        };
        
        for(int[] test : testCases) {
            System.out.println("Testing: " + java.util.Arrays.toString(test) + 
                             " ==> " + binaryArrayToNumber(test));
        }
    }
}
