package Vanilla.openai;
public class Task35 {
    public static int numberOfPeopleOnBus(int[][] stops) {
        int peopleOnBus = 0;
        for (int[] stop : stops) {
            peopleOnBus += stop[0];
            peopleOnBus -= stop[1];
        }
        return peopleOnBus;
    }

    public static void main(String[] args) {
        System.out.println(numberOfPeopleOnBus(new int[][]{{3, 0}, {9, 1}, {4, 8}, {12, 2}, {6, 1}, {7, 8}})); // 5
        System.out.println(numberOfPeopleOnBus(new int[][]{{10, 0}, {3, 5}, {5, 8}})); // 5
        System.out.println(numberOfPeopleOnBus(new int[][]{{3, 0}, {2, 1}, {5, 5}, {8, 2}, {6, 4}})); // 12
        System.out.println(numberOfPeopleOnBus(new int[][]{{0, 0}, {2, 1}, {5, 3}, {3, 2}})); // 4
        System.out.println(numberOfPeopleOnBus(new int[][]{{5, 0}, {0, 0}, {0, 0}, {2, 1}})); // 6
    }
}