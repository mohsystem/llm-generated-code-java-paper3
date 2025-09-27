package CoT.codestral;
import java.util.*;

public class Task166 {
    public static Integer[] posNegSort(Integer[] arr) {
        List<Integer> pos = new ArrayList<>();
        for (Integer num : arr) {
            if (num > 0) {
                pos.add(num);
            }
        }
        Collections.sort(pos);
        int posIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                arr[i] = pos.get(posIndex);
                posIndex++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(posNegSort(new Integer[]{6, 3, -2, 5, -8, 2, -2})));
        System.out.println(Arrays.toString(posNegSort(new Integer[]{6, 5, 4, -1, 3, 2, -1, 1})));
        System.out.println(Arrays.toString(posNegSort(new Integer[]{-5, -5, -5, -5, 7, -5})));
        System.out.println(Arrays.toString(posNegSort(new Integer[]{})));
    }
}