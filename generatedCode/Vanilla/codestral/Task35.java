package Vanilla.codestral;
public class Task35 {
    public static int number(int[][] busStops) {
        int totalPeople = 0;
        for (int[] busStop : busStops) {
            totalPeople += busStop[0] - busStop[1];
        }
        return totalPeople;
    }

    public static void main(String[] args) {
        System.out.println(number(new int[][]{{10,0},{3,5},{5,8}})); // Output: 5
        System.out.println(number(new int[][]{{3,0},{9,1},{4,10},{12,2},{6,1},{7,10}})); // Output: 17
        System.out.println(number(new int[][]{{3,0},{9,1},{4,8},{12,2},{6,1},{7,8}})); // Output: 21
        System.out.println(number(new int[][]{{0,0}})); // Output: 0
        System.out.println(number(new int[][]{{10,10},{10,10}})); // Output: 0
    }
}