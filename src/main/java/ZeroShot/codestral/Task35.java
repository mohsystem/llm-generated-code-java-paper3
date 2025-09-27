package ZeroShot.codestral;
public class Task35 {
    public static int number(int[][] arr) {
        int numPeople = 0;
        for (int[] pair : arr) {
            numPeople += pair[0] - pair[1];
        }
        return numPeople;
    }

    public static void main(String[] args) {
        int[][] test1 = {{10, 0}, {3, 5}, {5, 8}};
        int[][] test2 = {{3, 0}, {9, 1}, {4, 10}, {12, 2}, {6, 1}, {7, 10}};
        int[][] test3 = {{3, 0}, {9, 1}, {4, 8}, {12, 2}, {6, 1}, {7, 8}};
        int[][] test4 = {{0, 0}};
        int[][] test5 = {{2, 2}};

        System.out.println(number(test1));
        System.out.println(number(test2));
        System.out.println(number(test3));
        System.out.println(number(test4));
        System.out.println(number(test5));
    }
}