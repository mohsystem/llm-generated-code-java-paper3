package Vanilla.gemini;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task166 {

    public static int[] posNegSort(int[] arr) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> negIndices = new ArrayList<>();
        List<Integer> negValues = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                pos.add(arr[i]);
            } else {
                negIndices.add(i);
                negValues.add(arr[i]);
            }
        }

        Collections.sort(pos);

        int[] result = new int[arr.length];
        int posIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (posIndex < pos.size() && (negIndices.isEmpty() || i < negIndices.get(0))) {
                result[i] = pos.get(posIndex++);
            } else if (!negIndices.isEmpty() && i == negIndices.get(0)) {
                result[i] = negValues.get(0);
                negIndices.remove(0);
                negValues.remove(0);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(posNegSort(new int[]{6, 3, -2, 5, -8, 2, -2})));
        System.out.println(Arrays.toString(posNegSort(new int[]{6, 5, 4, -1, 3, 2, -1, 1})));
        System.out.println(Arrays.toString(posNegSort(new int[]{-5, -5, -5, -5, 7, -5})));
        System.out.println(Arrays.toString(posNegSort(new int[]{})));
        System.out.println(Arrays.toString(posNegSort(new int[]{1, 2, 3, 4, -1, -2, -3})));


    }
}