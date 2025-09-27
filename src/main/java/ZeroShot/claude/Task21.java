package ZeroShot.claude;

import java.util.ArrayList;
import java.util.List;

public class Task21 {
    public static List<Integer> removeSmallest(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return new ArrayList<>();
        }
        
        List<Integer> result = new ArrayList<>(numbers);
        int minIndex = 0;
        for (int i = 1; i < result.size(); i++) {
            if (result.get(i) < result.get(minIndex)) {
                minIndex = i;
            }
        }
        result.remove(minIndex);
        return result;
    }

    public static void main(String[] args) {
        // Test cases
        List<Integer> test1 = List.of(1, 2, 3, 4, 5);
        List<Integer> test2 = List.of(5, 3, 2, 1, 4);
        List<Integer> test3 = List.of(2, 2, 1, 2, 1);
        List<Integer> test4 = new ArrayList<>();
        List<Integer> test5 = List.of(1);

        System.out.println(removeSmallest(test1)); // [2, 3, 4, 5]
        System.out.println(removeSmallest(test2)); // [5, 3, 2, 4]
        System.out.println(removeSmallest(test3)); // [2, 2, 2, 1]
        System.out.println(removeSmallest(test4)); // []
        System.out.println(removeSmallest(test5)); // []
    }
}
