package CoT.gpt4o;
public class Task1 {
    public static int peopleOnBus(int[][] busStops) {
        int totalPeople = 0;
        for (int[] stop : busStops) {
            totalPeople += stop[0] - stop[1];
        }
        return totalPeople;
    }

    public static void main(String[] args) {
        System.out.println(peopleOnBus(new int[][]{{10, 0}, {3, 5}, {5, 8}})); // 5
        System.out.println(peopleOnBus(new int[][]{{3, 0}, {9, 1}, {4, 10}, {12, 2}, {6, 1}, {7, 10}})); // 17
        System.out.println(peopleOnBus(new int[][]{{3, 0}, {9, 1}, {4, 8}, {12, 2}, {6, 1}, {7, 8}})); // 21
        System.out.println(peopleOnBus(new int[][]{{0, 0}})); // 0
        System.out.println(peopleOnBus(new int[][]{{10, 0}, {3, 5}, {2, 2}})); // 8
    }
}