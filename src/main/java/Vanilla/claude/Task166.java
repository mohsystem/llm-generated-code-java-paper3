package Vanilla.claude;

import java.util.*;

public class Task166 {
    public static int[] posNegSort(int[] arr) {
        List<Integer> positives = new ArrayList<>();
        for (int num : arr) {
            if (num > 0) {
                positives.add(num);
            }
        }
        Collections.sort(positives);
        
        int posIndex = 0;
        int[] result = arr.clone();
        for (int i = 0; i < result.length; i++) {
            if (result[i] > 0) {
                result[i] = positives.get(posIndex++);
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(Arrays.toString(posNegSort(new int[]{6, 3, -2, 5, -8, 2, -2})));
        System.out.println(Arrays.toString(posNegSort(new int[]{6, 5, 4, -1, 3, 2, -1, 1})));
        System.out.println(Arrays.toString(posNegSort(new int[]{-5, -5, -5, -5, 7, -5})));
        System.out.println(Arrays.toString(posNegSort(new int[]{})));
        System.out.println(Arrays.toString(posNegSort(new int[]{-1, 2, -3, 4, -5, 6, -7})));
    }
}
