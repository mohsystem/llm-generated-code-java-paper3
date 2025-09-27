package ourMethod.gpt4o;
import java.util.ArrayList;
import java.util.List;

public class Task22 {
    public static List<Integer> filterList(List<Object> list) {
        List<Integer> result = new ArrayList<>();
        for (Object obj : list) {
            if (obj instanceof Integer) {
                result.add((Integer) obj);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(filterList(List.of(1, 2, "a", "b"))); // [1, 2]
        System.out.println(filterList(List.of(1, "a", "b", 0, 15))); // [1, 0, 15]
        System.out.println(filterList(List.of(1, 2, "a", "b", "aasf", "1", "123", 123))); // [1, 2, 123]
        System.out.println(filterList(List.of("hello", "world", 3, 4))); // [3, 4]
        System.out.println(filterList(List.of(100, 200, "300"))); // [100, 200]
    }
}