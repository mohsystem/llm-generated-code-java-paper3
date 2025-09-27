package Vanilla.gpt4o;
import java.util.Arrays;

public class Task166 {

    public static int[] posNegSort(int[] arr) {
        int[] positives = Arrays.stream(arr).filter(x -> x > 0).sorted().toArray();
        int posIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                arr[i] = positives[posIndex++];
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(posNegSort(new int[]{6, 3, -2, 5, -8, 2, -2})));
        System.out.println(Arrays.toString(posNegSort(new int[]{6, 5, 4, -1, 3, 2, -1, 1})));
        System.out.println(Arrays.toString(posNegSort(new int[]{-5, -5, -5, -5, 7, -5})));
        System.out.println(Arrays.toString(posNegSort(new int[]{})));
        System.out.println(Arrays.toString(posNegSort(new int[]{1, -1, 2, -2, 3, -3})));
    }
}