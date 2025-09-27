package ourMethod.gemini;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Task1 {
    public static int peopleOnBus(List<int[]> stops) {
        int people = 0;
        for (int[] stop : stops) {
            people += stop[0] - stop[1];
        }
        return people;
    }

    public static void main(String[] args) {
        List<int[]> stops1 = new ArrayList<>();
        stops1.add(new int[]{10, 0});
        stops1.add(new int[]{3, 5});
        stops1.add(new int[]{2, 5});
        System.out.println(peopleOnBus(stops1)); // Output: 2

        List<int[]> stops2 = new ArrayList<>();
        stops2.add(new int[]{3, 0});
        stops2.add(new int[]{9, 1});
        stops2.add(new int[]{4, 10});
        stops2.add(new int[]{12, 2});
        stops2.add(new int[]{6, 1});
        stops2.add(new int[]{7, 10});
        System.out.println(peopleOnBus(stops2)); // Output: 17

        List<int[]> stops3 = new ArrayList<>();
        stops3.add(new int[]{3, 0});
        stops3.add(new int[]{9, 1});
        stops3.add(new int[]{4, 8});
        stops3.add(new int[]{12, 2});
        stops3.add(new int[]{6, 1});
        stops3.add(new int[]{7, 8});
        System.out.println(peopleOnBus(stops3)); // Output: 17

        List<int[]> stops4 = Arrays.asList(new int[]{1, 0}, new int[]{2, 0}, new int[]{3, 0});
        System.out.println(peopleOnBus(stops4));

        List<int[]> stops5 = Arrays.asList(new int[]{0, 0});
        System.out.println(peopleOnBus(stops5));
    }
}