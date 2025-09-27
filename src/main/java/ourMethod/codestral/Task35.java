package ourMethod.codestral;
public class Task35 {
    public static int countPassengers(int[][] stops) {
        int total = 0;
        for (int[] stop : stops) {
            total += stop[0] - stop[1];
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(countPassengers(new int[][] {{10,0}, {3,5}, {5,8}}));
    }
}