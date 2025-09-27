package CoT.codestral;
public class Task1 {
    public static int countPeople(int[][] busStops) {
        int peopleOnBus = 0;
        for (int[] stop : busStops) {
            peopleOnBus += stop[0] - stop[1];
        }
        return peopleOnBus;
    }

    public static void main(String[] args) {
        int[][] testCases = {
            {{10, 0}, {3, 5}, {5, 8}},
            {{3, 0}, {9, 1}, {4, 10}, {12, 2}, {6, 1}, {7, 10}},
            {{3, 0}, {9, 1}, {4, 8}, {12, 2}, {6, 1}, {7, 8}},
            {{0, 0}},
            {{10, 0}, {0, 5}, {2, 8}}
        };

        for (int[][] testCase : testCases) {
            System.out.println(countPeople(testCase));
        }
    }
}