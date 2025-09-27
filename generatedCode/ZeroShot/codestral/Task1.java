package ZeroShot.codestral;
public class Task1 {
    public static int busStop(int[][] arr) {
        int people = 0;
        for (int[] stop : arr) {
            people += stop[0] - stop[1];
        }
        return people;
    }

    public static void main(String[] args) {
        System.out.println(busStop(new int[][]{{10, 0}, {3, 5}, {5, 8}})); // Expected output: 5
        System.out.println(busStop(new int[][]{{3, 0}, {9, 1}, {4, 10}, {12, 2}, {6, 1}, {7, 10}})); // Expected output: 17
        // Add more test cases as needed
    }
}