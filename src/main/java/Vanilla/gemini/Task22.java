package Vanilla.gemini;
import java.util.ArrayList;
import java.util.List;

class Task22 {
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
        System.out.println(filterList(List.of(1, 2, "a", "b")));
        System.out.println(filterList(List.of(1, "a", "b", 0, 15)));
        System.out.println(filterList(List.of(1, 2, "a", "b", "aasf", "1", "123", 123)));
        System.out.println(filterList(List.of(1, 2, 3, 4, 5)));
        System.out.println(filterList(List.of("a", "b", "c", "d")));

    }
}