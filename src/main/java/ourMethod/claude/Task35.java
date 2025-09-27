package ourMethod.claude;

public class Task35 {
    public static int countPassengers(int[][] stops) {
        if (stops == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }
        if (stops.length == 0) {
            return 0;
        }
        
        int passengers = 0;
        
        for (int i = 0; i < stops.length; i++) {
            if (stops[i] == null || stops[i].length != 2) {
                throw new IllegalArgumentException("Each stop must contain exactly 2 values");
            }
            
            int getting_on = stops[i][0];
            int getting_off = stops[i][1];
            
            if (getting_on < 0 || getting_off < 0) {
                throw new IllegalArgumentException("Passenger numbers cannot be negative");
            }
            
            if (i == 0 && getting_off != 0) {
                throw new IllegalArgumentException("First stop must have 0 passengers getting off");
            }
            
            passengers += getting_on - getting_off;
            
            if (passengers < 0) {
                throw new IllegalArgumentException("Number of passengers cannot be negative");
            }
        }
        
        return passengers;
    }
    
    public static void main(String[] args) {
        // Test cases
        int[][] test1 = {{10,0}, {3,5}, {5,8}};
        int[][] test2 = {{3,0}, {4,2}, {5,5}};
        int[][] test3 = {{20,0}, {10,5}, {5,5}};
        int[][] test4 = {{5,0}};
        int[][] test5 = {{3,0}, {4,4}, {5,6}};
        
        System.out.println("Test 1: " + countPassengers(test1));  // Expected: 5
        System.out.println("Test 2: " + countPassengers(test2));  // Expected: 5
        System.out.println("Test 3: " + countPassengers(test3));  // Expected: 25
        System.out.println("Test 4: " + countPassengers(test4));  // Expected: 5
        System.out.println("Test 5: " + countPassengers(test5));  // Expected: 2
    }
}
