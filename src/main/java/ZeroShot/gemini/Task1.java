package ZeroShot.gemini;
public class Task1 {
    public static int peopleOnBus(int[][] stops) {
        int people = 0;
        for (int[] stop : stops) {
            people += stop[0] - stop[1];
        }
        return people;
    }

    public static void main(String[] args) {
        int[][] test1 = {{10, 0}, {3, 5}, {5, 8}};
        System.out.println(peopleOnBus(test1)); // 2

        int[][] test2 = {{3, 0}, {9, 1}, {4, 10}, {12, 2}, {6, 1}, {7, 10}};
        System.out.println(peopleOnBus(test2)); // 17

        int[][] test3 = {{3, 0}, {9, 1}, {4, 8}, {12, 2}, {6, 1}, {7, 8}};
        System.out.println(peopleOnBus(test3)); // 21

        int[][] test4 = {{0, 0}};
        System.out.println(peopleOnBus(test4)); //0

        int[][] test5 = {{10,0},{3,5},{2,1},{15,5}};
        System.out.println(peopleOnBus(test5)); //14

    }
}