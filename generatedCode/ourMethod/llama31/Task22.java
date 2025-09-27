package ourMethod.llama31;
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
        List<Object> list1 = List.of(1, 2, "a", "b");
        List<Object> list2 = List.of(1, "a", "b", 0, 15);
        List<Object> list3 = List.of(1, 2, "a", "b", "aasf", "1", "123", 123);

        System.out.println(filterList(list1)); // [1, 2]
        System.out.println(filterList(list2)); // [1, 0, 15]
        System.out.println(filterList(list3)); // [1, 2, 123]
    }
}