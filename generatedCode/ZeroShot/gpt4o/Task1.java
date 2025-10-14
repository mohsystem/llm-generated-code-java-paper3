package ZeroShot.openai;
public class Task1 {
    public static int numberOfPeopleOnBus(int[][] busStops) {
        int peopleOnBus = 0;
        for (int[] stop : busStops) {
            peopleOnBus += stop[0];
            peopleOnBus -= stop[1];
        }
        return peopleOnBus;
    }

    public static void main(String[] args) {
        System.out.println(numberOfPeopleOnBus(new int[][]{{10, 0}, {3, 5}, {5, 8}, {2, 1}, {8, 10}})); // 4
        System.out.println(numberOfPeopleOnBus(new int[][]{{3, 0}, {9, 1}, {4, 10}, {12, 2}, {6, 1}, {7, 10}})); // 17
        System.out.println(numberOfPeopleOnBus(new int[][]{{5, 0}, {2, 2}, {3, 3}, {1, 5}, {0, 0}})); // 1
        System.out.println(numberOfPeopleOnBus(new int[][]{{0, 0}, {4, 1}, {8, 2}, {4, 3}, {2, 4}})); // 8
        System.out.println(numberOfPeopleOnBus(new int[][]{{7, 0}, {3, 3}, {8, 5}, {1, 1}, {4, 6}})); // 8
    }
}