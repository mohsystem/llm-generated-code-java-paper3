package Vanilla.gemini;
import java.util.Arrays;

public class Task18 {
    public static int binaryArrayToInt(int[] binaryArray) {
        int result = 0;
        for (int bit : binaryArray) {
            result = (result << 1) | bit;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Testing: " + Arrays.toString(new int[]{0, 0, 0, 1}) + " ==> " + binaryArrayToInt(new int[]{0, 0, 0, 1}));
        System.out.println("Testing: " + Arrays.toString(new int[]{0, 0, 1, 0}) + " ==> " + binaryArrayToInt(new int[]{0, 0, 1, 0}));
        System.out.println("Testing: " + Arrays.toString(new int[]{0, 1, 0, 1}) + " ==> " + binaryArrayToInt(new int[]{0, 1, 0, 1}));
        System.out.println("Testing: " + Arrays.toString(new int[]{1, 0, 0, 1}) + " ==> " + binaryArrayToInt(new int[]{1, 0, 0, 1}));
        System.out.println("Testing: " + Arrays.toString(new int[]{0, 0, 1, 0}) + " ==> " + binaryArrayToInt(new int[]{0, 0, 1, 0}));
        System.out.println("Testing: " + Arrays.toString(new int[]{0, 1, 1, 0}) + " ==> " + binaryArrayToInt(new int[]{0, 1, 1, 0}));
        System.out.println("Testing: " + Arrays.toString(new int[]{1, 1, 1, 1}) + " ==> " + binaryArrayToInt(new int[]{1, 1, 1, 1}));
        System.out.println("Testing: " + Arrays.toString(new int[]{1, 0, 1, 1}) + " ==> " + binaryArrayToInt(new int[]{1, 0, 1, 1}));

    }
}