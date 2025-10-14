package ourMethodv2.gpt4o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task166 {
    public static int[] posNegSort(int[] arr) {
        List<Integer> positives = new ArrayList<>();
        for (int num : arr) {
            if (num > 0) {
                positives.add(num);
            }
        }
        Collections.sort(positives);
        
        int positiveIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                arr[i] = positives.get(positiveIndex++);
            }
        }
        return arr;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(posNegSort(new int[]{6, 3, -2, 5, -8, 2, -2}))); // [2, 3, -2, 5, -8, 6, -2]
        System.out.println(Arrays.toString(posNegSort(new int[]{6, 5, 4, -1, 3, 2, -1, 1}))); // [1, 2, 3, -1, 4, 5, -1, 6]
        System.out.println(Arrays.toString(posNegSort(new int[]{-5, -5, -5, -5, 7, -5}))); // [-5, -5, -5, -5, 7, -5]
        System.out.println(Arrays.toString(posNegSort(new int[]{}))); // []
        System.out.println(Arrays.toString(posNegSort(new int[]{1, -1, 3, 2, -2, 4}))); // [1, -1, 2, 3, -2, 4]
    }
}