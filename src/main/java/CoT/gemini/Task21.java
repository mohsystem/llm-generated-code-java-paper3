package CoT.gemini;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task21 {

    public static List<Integer> removeSmallest(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return new ArrayList<>();
        }

        int minIndex = 0;
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) < numbers.get(minIndex)) {
                minIndex = i;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (i != minIndex) {
                result.add(numbers.get(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> test1 = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(removeSmallest(test1)); // Output: [2, 3, 4, 5]

        List<Integer> test2 = Arrays.asList(5, 3, 2, 1, 4);
        System.out.println(removeSmallest(test2)); // Output: [5, 3, 2, 4]

        List<Integer> test3 = Arrays.asList(2, 2, 1, 2, 1);
        System.out.println(removeSmallest(test3)); // Output: [2, 2, 2, 1]

        List<Integer> test4 = new ArrayList<>();
        System.out.println(removeSmallest(test4)); // Output: []

        List<Integer> test5 = Arrays.asList(5);
        System.out.println(removeSmallest(test5)); // Output: []


    }
}