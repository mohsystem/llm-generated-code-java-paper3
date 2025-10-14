package CoT.openai;
import java.util.ArrayList;
import java.util.List;

public class Task22 {
    public static List<Integer> filterList(List<Object> list) {
        List<Integer> result = new ArrayList<>();
        for (Object item : list) {
            if (item instanceof Integer) {
                result.add((Integer) item);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(filterList(List.of(1, 2, "a", "b"))); // Output: [1, 2]
        System.out.println(filterList(List.of(1, "a", "b", 0, 15))); // Output: [1, 0, 15]
        System.out.println(filterList(List.of(1, 2, "a", "b", "aasf", "1", "123", 123))); // Output: [1, 2, 123]
        System.out.println(filterList(List.of("x", "y", "z"))); // Output: []
        System.out.println(filterList(List.of(10, 20, 30, "40", "fifty"))); // Output: [10, 20, 30]
    }
}