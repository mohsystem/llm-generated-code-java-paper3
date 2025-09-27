package CoT.gemini;
import java.util.ArrayList;
import java.util.List;

public class Task22 {

    public static List<Integer> filterList(List<?> mixedList) {
        List<Integer> integerList = new ArrayList<>();
        for (Object item : mixedList) {
            if (item instanceof Integer) {
                integerList.add((Integer) item);
            }
        }
        return integerList;
    }

    public static void main(String[] args) {
        List<Object> test1 = new ArrayList<>(List.of(1, 2, "a", "b"));
        List<Integer> result1 = filterList(test1);
        System.out.println(result1); // Output: [1, 2]

        List<Object> test2 = new ArrayList<>(List.of(1, "a", "b", 0, 15));
        List<Integer> result2 = filterList(test2);
        System.out.println(result2); // Output: [1, 0, 15]

        List<Object> test3 = new ArrayList<>(List.of(1, 2, "a", "b", "aasf", "1", "123", 123));
        List<Integer> result3 = filterList(test3);
        System.out.println(result3); // Output: [1, 2, 123]

        List<Object> test4 = new ArrayList<>();
        List<Integer> result4 = filterList(test4);
        System.out.println(result4); // Output: []

        List<Object> test5 = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        List<Integer> result5 = filterList(test5);
        System.out.println(result5); // Output: [1, 2, 3, 4, 5]


    }
}