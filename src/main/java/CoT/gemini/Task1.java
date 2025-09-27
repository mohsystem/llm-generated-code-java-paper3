package CoT.gemini;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task1 {

    public static int peopleOnBus(List<int[]> stops) {
        int people = 0;
        for (int[] stop : stops) {
            people += stop[0];
            people -= stop[1];
        }
        return people;
    }

    public static void main(String[] args) {
        List<int[]> test1 = Arrays.asList(new int[]{10, 0}, new int[]{3, 5}, new int[]{5, 8});
        List<int[]> test2 = Arrays.asList(new int[]{3, 0}, new int[]{9, 1}, new int[]{4, 10}, new int[]{12, 2}, new int[]{6, 1}, new int[]{7, 10});
        List<int[]> test3 = Arrays.asList(new int[]{3, 0}, new int[]{9, 1}, new int[]{4, 8}, new int[]{12, 2}, new int[]{6, 1}, new int[]{7, 8});
        List<int[]> test4 = new ArrayList<>();
        List<int[]> test5 = Arrays.asList(new int[]{0, 0});


        System.out.println("Test 1: " + peopleOnBus(test1)); // Expected 5
        System.out.println("Test 2: " + peopleOnBus(test2)); // Expected 17
        System.out.println("Test 3: " + peopleOnBus(test3)); // Expected 21
        System.out.println("Test 4: " + peopleOnBus(test4)); // Expected 0
        System.out.println("Test 5: " + peopleOnBus(test5)); // Expected 0
    }
}