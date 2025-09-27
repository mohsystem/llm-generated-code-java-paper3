package ourMethod.llama31;
public class Task1 {
    public static int countPeopleOnBus(int[][] stops) {
        int peopleOnBus = 0;
        for (int[] stop : stops) {
            peopleOnBus += stop[0] - stop[1];
            if (peopleOnBus < 0) {
                throw new IllegalArgumentException("Number of people on the bus cannot be negative.");
            }
        }
        return peopleOnBus;
    }

    public static void main(String[] args) {
        int[][] testCases = {
            {10, 0}, {3, 5}, {5, 8}
        };
        System.out.println(countPeopleOnBus(testCases)); // Example test case

        int[][] testCase2 = {
            {10, 0}, {3, 5}, {5, 8}, {2, 2}
        };
        System.out.println(countPeopleOnBus(testCase2)); // Another example test case
    }
}