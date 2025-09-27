package ZeroShot.claude;

public class Task1 {
    public static int countPassengers(int[][] stops) {
        int people = 0;
        for (int[] stop : stops) {
            people += stop[0] - stop[1];
        }
        return people;
    }
    
    public static void main(String[] args) {
        // Test cases
        int[][] test1 = {{10,0}, {3,5}, {5,8}};  // Expected: 5
        int[][] test2 = {{3,0}, {4,2}, {5,5}};   // Expected: 5
        int[][] test3 = {{20,0}, {10,5}, {5,15}, {5,10}}; // Expected: 10
        int[][] test4 = {{5,0}, {0,3}, {2,4}};   // Expected: 0
        int[][] test5 = {{15,0}, {10,5}, {7,8}}; // Expected: 19
        
        System.out.println(countPassengers(test1));
        System.out.println(countPassengers(test2));
        System.out.println(countPassengers(test3));
        System.out.println(countPassengers(test4));
        System.out.println(countPassengers(test5));
    }
}
