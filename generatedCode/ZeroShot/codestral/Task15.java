package ZeroShot.codestral;
public class Task15 {
    public static String[] towerBuilder(int nFloors) {
        String[] tower = new String[nFloors];
        for (int i = 0; i < nFloors; i++) {
            tower[i] = " ".repeat(nFloors - 1 - i) + "*".repeat((i * 2) + 1) + " ".repeat(nFloors - 1 - i);
        }
        return tower;
    }

    public static void main(String[] args) {
        String[] tower = towerBuilder(3);
        for (String floor : tower) {
            System.out.println(floor);
        }

        tower = towerBuilder(6);
        for (String floor : tower) {
            System.out.println(floor);
        }
    }
}