package CoT.claude;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task1 {
    public static int countPassengers(List<int[]> stops) {
        int total = 0;
        for(int[] stop : stops) {
            if(stop.length != 2) {
                throw new IllegalArgumentException("Each stop must have exactly 2 values");
            }
            if(stop[0] < 0 || stop[1] < 0) {
                throw new IllegalArgumentException("Number of passengers cannot be negative");
            }
            total += stop[0] - stop[1];
            if(total < 0) {
                throw new IllegalArgumentException("Total passengers cannot be negative");
            }
        }
        return total;
    }
    
    public static void main(String[] args) {
        // Test cases
        List<int[]> test1 = Arrays.asList(new int[] {10,0}, new int[] {3,5}, new int[] {2,5});
        List<int[]> test2 = Arrays.asList(new int[] {3,0}, new int[] {4,2}, new int[] {5,5});
        List<int[]> test3 = Arrays.asList(new int[] {20,0}, new int[] {10,5}, new int[] {5,15});
        List<int[]> test4 = Arrays.asList(new int[] {5,0}, new int[] {0,3}, new int[] {2,4});
        List<int[]> test5 = Arrays.asList(new int[] {15,0}, new int[] {5,5}, new int[] {5,8});
        
        System.out.println("Test 1: " + countPassengers(test1)); // Expected: 5
        System.out.println("Test 2: " + countPassengers(test2)); // Expected: 5
        System.out.println("Test 3: " + countPassengers(test3)); // Expected: 15
        System.out.println("Test 4: " + countPassengers(test4)); // Expected: 0
        System.out.println("Test 5: " + countPassengers(test5)); // Expected: 12
    }
}
