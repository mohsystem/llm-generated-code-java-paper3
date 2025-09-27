package ourMethod.gemini;
import java.util.Arrays;

public class Task18 {
    public static int binaryArrayToInt(int[] binaryArray) {
        int result = 0;
        for (int i = 0; i < binaryArray.length; i++) {
            if (binaryArray[i] != 0 && binaryArray[i] != 1) {
                throw new IllegalArgumentException("Array elements must be 0 or 1.");
            }
            result = (result << 1) | binaryArray[i]; // Avoids potential integer overflow.
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test1 = {0, 0, 0, 1};
        int[] test2 = {0, 0, 1, 0};
        int[] test3 = {0, 1, 0, 1};
        int[] test4 = {1, 0, 0, 1};
        int[] test5 = {1, 1, 1, 1};


        System.out.println("Testing: " + Arrays.toString(test1) + " ==> " + binaryArrayToInt(test1));
        System.out.println("Testing: " + Arrays.toString(test2) + " ==> " + binaryArrayToInt(test2));
        System.out.println("Testing: " + Arrays.toString(test3) + " ==> " + binaryArrayToInt(test3));
        System.out.println("Testing: " + Arrays.toString(test4) + " ==> " + binaryArrayToInt(test4));
        System.out.println("Testing: " + Arrays.toString(test5) + " ==> " + binaryArrayToInt(test5));
    }
}