package CoT.codestral;
public class Task35 {
    public static int numberOfPeople(int[][] stops) {
        int peopleInBus = 0;
        for (int[] stop : stops) {
            peopleInBus += stop[0] - stop[1];
        }
        return peopleInBus;
    }

    public static void main(String[] args) {
        int[][][] testCases = {
            {{10, 0}, {3, 5}, {2, 5}},
            {{3, 0}, {9, 1}, {4, 10}, {12, 2}, {6, 1}, {7, 10}},
            {{3, 0}, {9, 1}, {4, 8}, {12, 2}, {6, 1}, {7, 8}},
            {{3, 0}, {9, 1}, {4, 8}, {12, 2}, {6, 1}, {7, 8}},
            {{0, 0}}
        };
        for (int[][] testCase : testCases) {
            System.out.println(numberOfPeople(testCase));
        }
    }
}