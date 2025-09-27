package ZeroShot.gpt4o;
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
        System.out.println(filterList(List.of("test", "filter", 123, 456))); // [123, 456]
        System.out.println(filterList(List.of(10, 20, "30", 40, "50"))); // [10, 20, 40]
    }
}