package ourMethod.gemini;
import java.util.List;
import java.util.ArrayList;

public class Task22 {

    public static List<Integer> filterList(List<?> list) {
        List<Integer> filteredList = new ArrayList<>();
        for (Object obj : list) {
            if (obj instanceof Integer) {
                filteredList.add((Integer) obj);
            }
        }
        return filteredList;
    }

    public static void main(String[] args) {
        List<Object> test1 = List.of(1, 2, "a", "b");
        List<Object> test2 = List.of(1, "a", "b", 0, 15);
        List<Object> test3 = List.of(1, 2, "a", "b", "aasf", "1", "123", 123);
        List<Object> test4 = List.of("1", "2", "3");
        List<Object> test5 = List.of(1, 2, 3, 4, 5);


        System.out.println(filterList(test1));
        System.out.println(filterList(test2));
        System.out.println(filterList(test3));
        System.out.println(filterList(test4));
        System.out.println(filterList(test5));
    }
}