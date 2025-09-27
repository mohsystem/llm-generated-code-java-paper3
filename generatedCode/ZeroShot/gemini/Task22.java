package ZeroShot.gemini;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Task22 {
    public static List<Integer> filterList(List<?> list) {
        List<Integer> result = new ArrayList<>();
        for (Object obj : list) {
            if (obj instanceof Integer) {
                result.add((Integer) obj);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(filterList(Arrays.asList(1, 2, "a", "b"))); // Output: [1, 2]
        System.out.println(filterList(Arrays.asList(1, "a", "b", 0, 15))); // Output: [1, 0, 15]
        System.out.println(filterList(Arrays.asList(1, 2, "a", "b", "aasf", "1", "123", 123))); // Output: [1, 2, 123]
        System.out.println(filterList(Arrays.asList(1, 2, 3, 4))); // Output: [1, 2, 3, 4]
        System.out.println(filterList(Arrays.asList("a", "b", "c"))); // Output: []


    }
}