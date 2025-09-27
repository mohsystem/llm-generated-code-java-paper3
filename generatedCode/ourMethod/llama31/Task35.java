package ourMethod.llama31;
public class Task35 {
    public static int number_of_people_on_bus(int[][] stops) {
        int peopleOnBus = 0;
        for (int[] stop : stops) {
            peopleOnBus += stop[0] - stop[1];
            // Ensure the number of people does not go below 0
            peopleOnBus = Math.max(peopleOnBus, 0);
        }
        return peopleOnBus;
    }

    public static void main(String[] args) {
        int[][] testCases = {
            {10, 0}, {3, 5}, {5, 8}
        };
        System.out.println(number_of_people_on_bus(testCases)); // Expected output: 0

        int[][] testCases2 = {
            {3, 0}, {9, 1}, {4, 10}, {12, 2}, {6, 1}, {7, 10}
        };
        System.out.println(number_of_people_on_bus(testCases2)); // Expected output: 17

        int[][] testCases3 = {
            {3, 0}, {9, 1}, {4, 8}, {12, 2}, {6, 1}, {7, 8}
        };
        System.out.println(number_of_people_on_bus(testCases3)); // Expected output: 21
    }
}