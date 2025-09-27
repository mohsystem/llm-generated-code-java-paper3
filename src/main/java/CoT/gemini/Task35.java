package CoT.gemini;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task35 {

    public static int peopleOnBus(List<int[]> stops) {
        int people = 0;
        for (int[] stop : stops) {
            people += stop[0];
            people -= stop[1];
        }
        return people;
    }

    public static void main(String[] args) {
        List<int[]> stops1 = new ArrayList<>();
        stops1.add(new int[]{10, 0});
        stops1.add(new int[]{3, 5});
        stops1.add(new int[]{2, 4});
        System.out.println(peopleOnBus(stops1)); // Output: 4

        List<int[]> stops2 = new ArrayList<>();
        stops2.add(new int[]{5, 0});
        stops2.add(new int[]{7, 2});
        stops2.add(new int[]{1, 9});
        System.out.println(peopleOnBus(stops2)); // Output: 1

        List<int[]> stops3 = new ArrayList<>();
        stops3.add(new int[]{0, 0});
        System.out.println(peopleOnBus(stops3)); // Output: 0

        List<int[]> stops4 = new ArrayList<>();
        stops4.add(new int[]{10, 5});
        stops4.add(new int[]{3, 8});
        System.out.println(peopleOnBus(stops4)); // Output: 0

        List<int[]> stops5 = new ArrayList<>();
        stops5.add(new int[]{5, 0});
        stops5.add(new int[]{2, 2});
        stops5.add(new int[]{3, 1});
        System.out.println(peopleOnBus(stops5)); // Output: 5
    }
}