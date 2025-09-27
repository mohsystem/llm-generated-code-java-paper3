package Vanilla.gpt4o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        System.out.println(filterList(Arrays.asList(1, 2, "a", "b"))); // [1, 2]
        System.out.println(filterList(Arrays.asList(1, "a", "b", 0, 15))); // [1, 0, 15]
        System.out.println(filterList(Arrays.asList(1, 2, "a", "b", "aasf", "1", "123", 123))); // [1, 2, 123]
        System.out.println(filterList(Arrays.asList("hello", 3, "world", 4))); // [3, 4]
        System.out.println(filterList(Arrays.asList(5, 6, "test", 7, "filter"))); // [5, 6, 7]
    }
}