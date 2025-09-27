package Vanilla.codestral;
import java.util.List;
import java.util.ArrayList;

public class Task22 {
    public static List<Object> filterList(List<Object> list) {
        List<Object> result = new ArrayList<>();
        for (Object obj : list) {
            if (obj instanceof Integer) {
                result.add(obj);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(filterList(List.of(1, 2, "a", "b"))); // Output: [1, 2]
        System.out.println(filterList(List.of(1, "a", "b", 0, 15))); // Output: [1, 0, 15]
        System.out.println(filterList(List.of(1, 2, "a", "b", "aasf", "1", "123", 123))); // Output: [1, 2, 123]
    }
}