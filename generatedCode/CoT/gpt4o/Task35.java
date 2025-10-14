package CoT.openai;
public class Task35 {
    public static int peopleOnBus(int[][] busStops) {
        int peopleOnBus = 0;
        for (int[] stop : busStops) {
            peopleOnBus += stop[0] - stop[1];
        }
        return peopleOnBus;
    }

    public static void main(String[] args) {
        System.out.println(peopleOnBus(new int[][]{{10, 0}, {3, 5}, {5, 8}})); // Output: 5
        System.out.println(peopleOnBus(new int[][]{{3, 0}, {9, 1}, {4, 10}, {12, 2}, {6, 1}, {7, 10}})); // Output: 17
        System.out.println(peopleOnBus(new int[][]{{3, 0}, {9, 1}, {4, 8}, {12, 2}, {6, 1}, {7, 8}})); // Output: 21
        System.out.println(peopleOnBus(new int[][]{{0, 0}})); // Output: 0
        System.out.println(peopleOnBus(new int[][]{{10, 0}, {0, 5}, {5, 5}})); // Output: 5
    }
}