package ourMethodv2.gpt4o;
import java.util.ArrayList;
import java.util.List;

public class Task22 {
    public static List<Integer> filterList(List<Object> list) {
        List<Integer> filteredList = new ArrayList<>();
        for (Object item : list) {
            if (item instanceof Integer) {
                filteredList.add((Integer) item);
            }
        }
        return filteredList;
    }

    public static void main(String[] args) {
        System.out.println(filterList(List.of(1, 2, "a", "b"))); // [1, 2]
        System.out.println(filterList(List.of(1, "a", "b", 0, 15))); // [1, 0, 15]
        System.out.println(filterList(List.of(1, 2, "a", "b", "aasf", "1", "123", 123))); // [1, 2, 123]
        System.out.println(filterList(List.of("hello", 5, "world", 10, 20))); // [5, 10, 20]
        System.out.println(filterList(List.of(100, 200, "test", "case", 300))); // [100, 200, 300]
    }
}