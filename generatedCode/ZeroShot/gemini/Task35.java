package ZeroShot.gemini;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Task35 {
    public static int peopleOnBus(List<List<Integer>> stops) {
        int people = 0;
        for (List<Integer> stop : stops) {
            people += stop.get(0) - stop.get(1);
        }
        return people;
    }

    public static void main(String[] args) {
        List<List<Integer>> test1 = Arrays.asList(Arrays.asList(10, 0), Arrays.asList(3, 5), Arrays.asList(5, 8));
        System.out.println(peopleOnBus(test1)); // Output: 5

        List<List<Integer>> test2 = Arrays.asList(Arrays.asList(3, 0), Arrays.asList(9, 1), Arrays.asList(4, 10), Arrays.asList(12, 2), Arrays.asList(6, 1), Arrays.asList(7, 10));
        System.out.println(peopleOnBus(test2)); // Output: 17

        List<List<Integer>> test3 = Arrays.asList(Arrays.asList(3, 0), Arrays.asList(9, 1), Arrays.asList(4, 8), Arrays.asList(12, 2), Arrays.asList(6, 1), Arrays.asList(7, 8));
        System.out.println(peopleOnBus(test3)); // Output: 21

        List<List<Integer>> test4 = new ArrayList<>();
        System.out.println(peopleOnBus(test4)); // Output: 0

        List<List<Integer>> test5 = Arrays.asList(Arrays.asList(5, 0), Arrays.asList(0, 2), Arrays.asList(3, 1));
        System.out.println(peopleOnBus(test5)); // Output: 6
    }
}