package Vanilla.claude;

public class Task35 {
    public static int countPassengers(int[][] stops) {
        int total = 0;
        for(int[] stop : stops) {
            total += stop[0] - stop[1];
        }
        return total;
    }
    
    public static void main(String[] args) {
        // Test cases
        int[][] test1 = {{10,0}, {3,5}, {2,5}};
        int[][] test2 = {{3,0}, {4,2}, {5,5}};
        int[][] test3 = {{20,0}, {10,5}, {5,15}};
        int[][] test4 = {{5,0}, {7,3}, {2,4}, {9,2}};
        int[][] test5 = {{2,0}, {3,1}, {4,2}, {5,3}, {1,4}};
        
        System.out.println(countPassengers(test1)); // Expected: 5
        System.out.println(countPassengers(test2)); // Expected: 5
        System.out.println(countPassengers(test3)); // Expected: 15
        System.out.println(countPassengers(test4)); // Expected: 14
        System.out.println(countPassengers(test5)); // Expected: 5
    }
}
