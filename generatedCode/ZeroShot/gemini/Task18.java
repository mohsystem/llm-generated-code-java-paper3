package ZeroShot.gemini;
import java.util.Arrays;

class Task18 {
    public static int binaryArrayToInt(int[] binaryArray) {
        int result = 0;
        for (int bit : binaryArray) {
            result = (result << 1) | bit;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test1 = {0, 0, 0, 1};
        int[] test2 = {0, 0, 1, 0};
        int[] test3 = {0, 1, 0, 1};
        int[] test4 = {1, 0, 0, 1};
        int[] test5 = {0, 0, 1, 0};
        int[] test6 = {0, 1, 1, 0};
        int[] test7 = {1, 1, 1, 1};
        int[] test8 = {1, 0, 1, 1};

        System.out.println("Testing: " + Arrays.toString(test1) + " ==> " + binaryArrayToInt(test1));
        System.out.println("Testing: " + Arrays.toString(test2) + " ==> " + binaryArrayToInt(test2));
        System.out.println("Testing: " + Arrays.toString(test3) + " ==> " + binaryArrayToInt(test3));
        System.out.println("Testing: " + Arrays.toString(test4) + " ==> " + binaryArrayToInt(test4));
        System.out.println("Testing: " + Arrays.toString(test5) + " ==> " + binaryArrayToInt(test5));
        System.out.println("Testing: " + Arrays.toString(test6) + " ==> " + binaryArrayToInt(test6));
        System.out.println("Testing: " + Arrays.toString(test7) + " ==> " + binaryArrayToInt(test7));
        System.out.println("Testing: " + Arrays.toString(test8) + " ==> " + binaryArrayToInt(test8));

    }
}