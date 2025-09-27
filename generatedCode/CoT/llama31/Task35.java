package CoT.llama31;
public class Task35 {
    public static int countPeopleOnBus(int[][] stops) {
        int peopleOnBus = 0;
        for (int[] stop : stops) {
            peopleOnBus += stop[0] - stop[1];
        }
        return peopleOnBus;
    }

    public static void main(String[] args) {
        int[][] testCases = {
            {10, 0}, {3, 5}, {5, 8}
        };
        System.out.println(countPeopleOnBus(testCases)); // Output: 5

        testCases = new int[][]{
            {3, 0}, {9, 1}, {4, 10}, {12, 2}, {6, 1}, {7, 10}
        };
        System.out.println(countPeopleOnBus(testCases)); // Output: 17

        testCases = new int[][]{
            {3, 0}, {9, 1}, {4, 8}, {12, 2}, {6, 1}, {7, 8}
        };
        System.out.println(countPeopleOnBus(testCases)); // Output: 21

        testCases = new int[][]{
            {0, 0}
        };
        System.out.println(countPeopleOnBus(testCases)); // Output: 0

        testCases = new int[][]{
            {0, 0}, {0, 0}
        };
        System.out.println(countPeopleOnBus(testCases)); // Output: 0
    }
}