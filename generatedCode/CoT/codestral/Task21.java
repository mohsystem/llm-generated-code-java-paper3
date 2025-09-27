package CoT.codestral;
import java.util.ArrayList;
import java.util.List;

public class Task21 {
    public static List<Integer> removeSmallest(int[] numbers) {
        if (numbers.length == 0) return new ArrayList<>();
        int min = numbers[0];
        int index = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
                index = i;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            if (i != index) {
                result.add(numbers[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(removeSmallest(new int[]{1,2,3,4,5})); // Output: [2,3,4,5]
        System.out.println(removeSmallest(new int[]{5,3,2,1,4})); // Output: [5,3,2,4]
        System.out.println(removeSmallest(new int[]{2,2,1,2,1})); // Output: [2,2,2,1]
    }
}