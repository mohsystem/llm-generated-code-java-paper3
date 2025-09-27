package ZeroShot.gpt4o;
import java.util.ArrayList;
import java.util.List;

public class Task21 {
    public static List<Integer> removeSmallest(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) return new ArrayList<>();
        List<Integer> result = new ArrayList<>(numbers);
        int minIndex = 0;
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) < numbers.get(minIndex)) {
                minIndex = i;
            }
        }
        result.remove(minIndex);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(removeSmallest(List.of(1, 2, 3, 4, 5)));
        System.out.println(removeSmallest(List.of(5, 3, 2, 1, 4)));
        System.out.println(removeSmallest(List.of(2, 2, 1, 2, 1)));
        System.out.println(removeSmallest(List.of(10)));
        System.out.println(removeSmallest(new ArrayList<>()));
    }
}