package ourMethod.gpt4o;
public class Task35 {
    public static int remainingPassengers(int[][] stops) {
        int passengers = 0;
        for (int[] stop : stops) {
            passengers += stop[0];
            passengers -= stop[1];
        }
        return passengers;
    }

    public static void main(String[] args) {
        System.out.println(remainingPassengers(new int[][]{{10, 0}, {3, 5}, {5, 8}})); // 5
        System.out.println(remainingPassengers(new int[][]{{3, 0}, {9, 1}, {4, 10}, {12, 2}, {6, 1}, {7, 10}})); // 17
        System.out.println(remainingPassengers(new int[][]{{3, 0}, {9, 1}, {4, 8}, {12, 2}, {6, 1}, {7, 8}})); // 21
        System.out.println(remainingPassengers(new int[][]{{0, 0}})); // 0
        System.out.println(remainingPassengers(new int[][]{{10, 0}, {5, 5}, {5, 10}})); // 0
    }
}