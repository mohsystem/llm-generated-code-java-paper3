package ZeroShot.llama31;
import java.util.ArrayList;
import java.util.List;

public class Task22 {
    public static List<Object> filterList(List<Object> list) {
        List<Object> result = new ArrayList<>();
        for (Object item : list) {
            if (item instanceof Integer) {
                result.add(item);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(filterList(List.of(1, 2, "a", "b"))); // [1, 2]
        System.out.println(filterList(List.of(1, "a", "b", 0, 15))); // [1, 0, 15]
        System.out.println(filterList(List.of(1, 2, "a", "b", "aasf", "1", "123", 123))); // [1, 2, 123]
        System.out.println(filterList(List.of("a", "b", "c"))); // []
        System.out.println(filterList(List.of(10, 20, 30))); // [10, 20, 30]
    }
}