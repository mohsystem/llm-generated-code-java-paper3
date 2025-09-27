package Vanilla.gpt4o;
import java.util.ArrayList;
import java.util.Arrays;

public class Task1 {
    public static int peopleOnTheBus(ArrayList<int[]> busStops) {
        int peopleOnBus = 0;
        for (int[] stop : busStops) {
            peopleOnBus += stop[0];
            peopleOnBus -= stop[1];
        }
        return peopleOnBus;
    }

    public static void main(String[] args) {
        ArrayList<int[]> test1 = new ArrayList<>(Arrays.asList(new int[]{10, 0}, new int[]{3, 5}, new int[]{2, 5}));
        ArrayList<int[]> test2 = new ArrayList<>(Arrays.asList(new int[]{3, 0}, new int[]{9, 1}, new int[]{4, 10}, new int[]{12, 2}, new int[]{6, 1}, new int[]{7, 10}));
        ArrayList<int[]> test3 = new ArrayList<>(Arrays.asList(new int[]{3, 0}, new int[]{9, 1}, new int[]{4, 8}, new int[]{12, 2}, new int[]{6, 1}, new int[]{7, 8}));
        ArrayList<int[]> test4 = new ArrayList<>(Arrays.asList(new int[]{0, 0}));
        ArrayList<int[]> test5 = new ArrayList<>(Arrays.asList(new int[]{5, 0}, new int[]{2, 2}, new int[]{3, 4}));

        System.out.println(peopleOnTheBus(test1)); // 5
        System.out.println(peopleOnTheBus(test2)); // 17
        System.out.println(peopleOnTheBus(test3)); // 21
        System.out.println(peopleOnTheBus(test4)); // 0
        System.out.println(peopleOnTheBus(test5)); // 4
    }
}