package ourMethodv2.gpt4o;
public class Task35 {
    public static int peopleOnBus(int[][] stops) {
        int peopleOnBus = 0;
        for (int[] stop : stops) {
            peopleOnBus += stop[0] - stop[1];
        }
        return peopleOnBus;
    }

    public static void main(String[] args) {
        int[][] test1 = {{10, 0}, {3, 5}, {5, 8}};
        int[][] test2 = {{3, 0}, {9, 1}, {4, 10}, {12, 2}, {6, 1}, {7, 10}};
        int[][] test3 = {{3, 0}, {9, 1}, {4, 8}, {12, 2}, {6, 1}, {7, 8}};
        int[][] test4 = {{0, 0}, {0, 0}, {0, 0}};
        int[][] test5 = {{1, 0}, {1, 0}, {1, 0}};

        System.out.println(peopleOnBus(test1)); // Output: 5
        System.out.println(peopleOnBus(test2)); // Output: 17
        System.out.println(peopleOnBus(test3)); // Output: 21
        System.out.println(peopleOnBus(test4)); // Output: 0
        System.out.println(peopleOnBus(test5)); // Output: 3
    }
}