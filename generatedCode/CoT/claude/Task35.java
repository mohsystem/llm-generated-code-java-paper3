package CoT.claude;

public class Task35 {
    public static int countPassengers(int[][] stops) {
        int passengers = 0;
        if (stops == null || stops.length == 0) {
            return 0;
        }
        
        for (int[] stop : stops) {
            if (stop != null && stop.length == 2) {
                passengers += stop[0] - stop[1];
            }
        }
        return Math.max(0, passengers);
    }
    
    public static void main(String[] args) {
        // Test cases
        int[][] test1 = {{10,0}, {3,5}, {5,8}};
        int[][] test2 = {{3,0}, {4,2}, {5,5}};
        int[][] test3 = {{20,0}, {10,5}, {5,15}};
        int[][] test4 = {{5,0}, {0,3}, {2,4}};
        int[][] test5 = {{15,0}, {10,5}, {5,8}, {3,10}};
        
        System.out.println("Test 1: " + countPassengers(test1));  // Expected: 5
        System.out.println("Test 2: " + countPassengers(test2));  // Expected: 5
        System.out.println("Test 3: " + countPassengers(test3));  // Expected: 15
        System.out.println("Test 4: " + countPassengers(test4));  // Expected: 0
        System.out.println("Test 5: " + countPassengers(test5));  // Expected: 10
    }
}
