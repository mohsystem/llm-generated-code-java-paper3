package ourMethod.gpt4o;
public class Task1 {
    public static int remainingPassengers(int[][] busStops) {
        int passengers = 0;
        for (int[] stop : busStops) {
            passengers += stop[0];
            passengers -= stop[1];
        }
        return passengers;
    }

    public static void main(String[] args) {
        System.out.println(remainingPassengers(new int[][]{{10, 0}, {3, 5}, {5, 8}, {2, 2}, {1, 0}})); // Output: 6
        System.out.println(remainingPassengers(new int[][]{{3, 0}, {9, 1}, {4, 8}, {12, 2}, {6, 1}, {7, 8}})); // Output: 21
        System.out.println(remainingPassengers(new int[][]{{0, 0}, {5, 2}, {2, 5}, {4, 3}})); // Output: 1
        System.out.println(remainingPassengers(new int[][]{{2, 0}, {3, 1}, {8, 2}, {4, 2}})); // Output: 12
        System.out.println(remainingPassengers(new int[][]{{0, 0}})); // Output: 0
    }
}