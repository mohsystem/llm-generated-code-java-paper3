package Vanilla.openai;
import java.util.Arrays;

public class Task21 {
    public static int[] removeSmallest(int[] numbers) {
        if (numbers.length == 0) return new int[0];
        int minIndex = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[minIndex]) {
                minIndex = i;
            }
        }
        int[] result = new int[numbers.length - 1];
        for (int i = 0, j = 0; i < numbers.length; i++) {
            if (i != minIndex) {
                result[j++] = numbers[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(removeSmallest(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(removeSmallest(new int[]{5, 3, 2, 1, 4})));
        System.out.println(Arrays.toString(removeSmallest(new int[]{2, 2, 1, 2, 1})));
        System.out.println(Arrays.toString(removeSmallest(new int[]{1})));
        System.out.println(Arrays.toString(removeSmallest(new int[]{})));
    }
}