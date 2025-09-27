package ZeroShot.gpt4o;
public class Task35 {
    public static int peopleOnBus(int[][] busStops) {
        int peopleOnBus = 0;
        for (int[] stop : busStops) {
            peopleOnBus += stop[0]; // People getting on
            peopleOnBus -= stop[1]; // People getting off
        }
        return peopleOnBus;
    }

    public static void main(String[] args) {
        System.out.println(peopleOnBus(new int[][]{{10, 0}, {3, 5}, {5, 8}})); // 5
        System.out.println(peopleOnBus(new int[][]{{3, 0}, {9, 1}, {4, 10}, {12, 2}, {6, 1}, {7, 10}})); // 17
        System.out.println(peopleOnBus(new int[][]{{3, 0}, {9, 1}, {4, 8}, {12, 2}, {6, 1}, {7, 8}})); // 21
        System.out.println(peopleOnBus(new int[][]{{0, 0}, {9, 1}, {4, 10}, {12, 2}, {6, 1}, {7, 10}})); // 14
        System.out.println(peopleOnBus(new int[][]{{10, 0}, {3, 1}, {5, 8}, {7, 3}, {2, 4}, {8, 2}})); // 17
    }
}