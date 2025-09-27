package CoT.gemini;
import java.util.Arrays;

public class Task18 {

    public static int binaryArrayToInt(int[] binaryArray) {
        int decimalValue = 0;
        int power = 0;
        for (int i = binaryArray.length - 1; i >= 0; i--) {
            if (binaryArray[i] == 1) {
                decimalValue += Math.pow(2, power);
            }
            power++;
        }
        return decimalValue;
    }

    public static void main(String[] args) {
        int[] test1 = {0, 0, 0, 1};
        int[] test2 = {0, 0, 1, 0};
        int[] test3 = {0, 1, 0, 1};
        int[] test4 = {1, 0, 0, 1};
        int[] test5 = {0, 1, 1, 0};
        int[] test6 = {1, 1, 1, 1};
        int[] test7 = {1, 0, 1, 1};


        System.out.println("Testing: " + Arrays.toString(test1) + " ==> " + binaryArrayToInt(test1));
        System.out.println("Testing: " + Arrays.toString(test2) + " ==> " + binaryArrayToInt(test2));
        System.out.println("Testing: " + Arrays.toString(test3) + " ==> " + binaryArrayToInt(test3));
        System.out.println("Testing: " + Arrays.toString(test4) + " ==> " + binaryArrayToInt(test4));
        System.out.println("Testing: " + Arrays.toString(test5) + " ==> " + binaryArrayToInt(test5));
        System.out.println("Testing: " + Arrays.toString(test6) + " ==> " + binaryArrayToInt(test6));
        System.out.println("Testing: " + Arrays.toString(test7) + " ==> " + binaryArrayToInt(test7));

    }
}