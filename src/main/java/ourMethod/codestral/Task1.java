package ourMethod.codestral;
public class Task1 {
    public static int countPeople(int[][] busStops) {
        int peopleOnBus = 0;
        for (int[] stop : busStops) {
            peopleOnBus += stop[0] - stop[1];
        }
        return peopleOnBus;
    }

    public static void main(String[] args) {
        int[][] testCase1 = {{10, 0}, {3, 5}, {5, 8}};
        System.out.println(countPeople(testCase1)); // Expected output: 5

        int[][] testCase2 = {{3, 0}, {9, 1}, {4, 10}, {12, 2}, {6, 1}, {7, 10}};
        System.out.println(countPeople(testCase2)); // Expected output: 17

        int[][] testCase3 = {{3, 0}, {9, 1}, {4, 8}, {12, 2}, {6, 1}, {7, 8}};
        System.out.println(countPeople(testCase3)); // Expected output: 21
    }
}