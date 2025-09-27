package Vanilla.codestral;
public class Task15 {
    public static String[] buildTower(int nFloors) {
        String[] tower = new String[nFloors];
        for (int i = 0; i < nFloors; i++) {
            tower[i] = " ".repeat(nFloors - i - 1) + "*".repeat(2 * i + 1) + " ".repeat(nFloors - i - 1);
        }
        return tower;
    }

    public static void main(String[] args) {
        String[] tower3 = buildTower(3);
        String[] tower6 = buildTower(6);
        for (String floor : tower3) {
            System.out.println(floor);
        }
        for (String floor : tower6) {
            System.out.println(floor);
        }
    }
}