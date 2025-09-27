package ourMethod.claude;

public class Task1 {
    public static int countPassengers(int[][] stops) {
        if (stops == null) {
            return 0;
        }
        
        int passengers = 0;
        for (int[] stop : stops) {
            if (stop == null || stop.length != 2 || stop[0] < 0 || stop[1] < 0) {
                return 0;
            }
            // Check for integer overflow
            if (passengers > Integer.MAX_VALUE - stop[0]) {
                return 0;
            }
            passengers += stop[0];
            // Ensure we don't go negative
            if (passengers < stop[1]) {
                return 0;
            }
            passengers -= stop[1];
        }
        return passengers;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(countPassengers(new int[][] {{10,0}, {3,5}, {5,8}}));  // Expected: 5
        System.out.println(countPassengers(new int[][] {{3,0}}));  // Expected: 3
        System.out.println(countPassengers(new int[][] {{20,0}, {10,5}, {5,15}}));  // Expected: 15
        System.out.println(countPassengers(new int[][] {{0,0}}));  // Expected: 0
        System.out.println(countPassengers(new int[][] {{10,0}, {0,10}}));  // Expected: 0
    }
}
