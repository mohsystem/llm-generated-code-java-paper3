package ZeroShot.llama31;
public class Task1 {
    public static int number_of_people_on_bus(int[][] people) {
        int peopleOnBus = 0;
        for (int[] pair : people) {
            peopleOnBus += pair[0] - pair[1];
        }
        return peopleOnBus;
    }

    public static void main(String[] args) {
        int[][] testCases = {
            {10, 0}, {3, 5}, {5, 8}
        };
        System.out.println(number_of_people_on_bus(testCases)); // Output: 5

        testCases = new int[][]{
            {3, 0}, {9, 1}, {4, 10}, {12, 2}, {6, 1}, {7, 10}
        };
        System.out.println(number_of_people_on_bus(testCases)); // Output: 17

        testCases = new int[][]{
            {3, 0}, {9, 1}, {4, 8}, {12, 2}, {6, 1}, {7, 8}
        };
        System.out.println(number_of_people_on_bus(testCases)); // Output: 21

        testCases = new int[][]{
            {0, 0}
        };
        System.out.println(number_of_people_on_bus(testCases)); // Output: 0

        testCases = new int[][]{
            {0, 0}, {0, 0}
        };
        System.out.println(number_of_people_on_bus(testCases)); // Output: 0
    }
}