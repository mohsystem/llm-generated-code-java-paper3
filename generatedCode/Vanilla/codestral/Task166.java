package Vanilla.codestral;
import java.util.Arrays;
import java.util.ArrayList;

public class Task166 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(posNegSort(new int[]{6, 3, -2, 5, -8, 2, -2})));
        System.out.println(Arrays.toString(posNegSort(new int[]{6, 5, 4, -1, 3, 2, -1, 1})));
        System.out.println(Arrays.toString(posNegSort(new int[]{-5, -5, -5, -5, 7, -5})));
        System.out.println(Arrays.toString(posNegSort(new int[]{})));
    }

    public static int[] posNegSort(int[] arr) {
        ArrayList<Integer> pos = new ArrayList<>();
        for (int num : arr) {
            if (num > 0) {
                pos.add(num);
            }
        }
        pos.sort(null);
        int posIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                arr[i] = pos.get(posIndex++);
            }
        }
        return arr;
    }
}