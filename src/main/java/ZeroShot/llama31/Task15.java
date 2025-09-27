package ZeroShot.llama31;
public class Task15 {
    public static void main(String[] args) {
        printTower(3);
        printTower(6);
        printTower(1);
        printTower(2);
        printTower(5);
    }

    public static void printTower(int n) {
        String[] tower = buildTower(n);
        for (String floor : tower) {
            System.out.println(floor);
        }
        System.out.println();
    }

    public static String[] buildTower(int n) {
        String[] tower = new String[n];
        for (int i = 0; i < n; i++) {
            int spaces = n - i - 1;
            int stars = 2 * i + 1;
            tower[i] = getFloor(spaces, stars);
        }
        return tower;
    }

    public static String getFloor(int spaces, int stars) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < spaces; i++) {
            sb.append(" ");
        }
        for (int i = 0; i < stars; i++) {
            sb.append("*");
        }
        for (int i = 0; i < spaces; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}