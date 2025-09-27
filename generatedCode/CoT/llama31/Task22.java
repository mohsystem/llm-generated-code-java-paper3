package CoT.llama31;
import java.util.ArrayList;
import java.util.List;

public class Task22 {
    public static List<Integer> filterList(List<Object> inputList) {
        List<Integer> result = new ArrayList<>();
        for (Object item : inputList) {
            if (item instanceof Integer) {
                result.add((Integer) item);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(filterList(List.of(1, 2, "a", "b"))); // [1, 2]
        System.out.println(filterList(List.of(1, "a", "b", 0, 15))); // [1, 0, 15]
        System.out.println(filterList(List.of(1, 2, "a", "b", "aasf", "1", "123", 123))); // [1, 2, 123]
        System.out.println(filterList(List.of("a", "b", "c"))); // []
        System.out.println(filterList(List.of(10, 20, 30))); // [10, 20, 30]
    }
}