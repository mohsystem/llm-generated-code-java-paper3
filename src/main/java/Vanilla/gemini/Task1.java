package Vanilla.gemini;
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
        List<int[]> stops1 = Arrays.asList(new int[]{10, 0}, new int[]{3, 5}, new int[]{2, 5});
        System.out.println(peopleOnBus(stops1)); // 2

        List<int[]> stops2 = Arrays.asList(new int[]{3, 0}, new int[]{9, 1}, new int[]{4, 10}, new int[]{12, 2}, new int[]{6, 1}, new int[]{7, 10});
        System.out.println(peopleOnBus(stops2)); // 17

        List<int[]> stops3 = Arrays.asList(new int[]{3, 0}, new int[]{9, 1}, new int[]{4, 8}, new int[]{12, 2}, new int[]{6, 1}, new int[]{7, 8});
        System.out.println(peopleOnBus(stops3)); // 21

        List<int[]> stops4 = new ArrayList<>();
        System.out.println(peopleOnBus(stops4)); //0

        List<int[]> stops5 = Arrays.asList(new int[]{0, 0});
        System.out.println(peopleOnBus(stops5)); //0

    }
}