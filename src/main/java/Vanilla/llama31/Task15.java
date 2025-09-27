package Vanilla.llama31;
public class Task15 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            String[] tower = buildTower(i);
            for (String floor : tower) {
                System.out.println(floor);
            }
            System.out.println();
        }
    }

    public static String[] buildTower(int nFloors) {
        String[] tower = new String[nFloors];
        for (int i = 0; i < nFloors; i++) {
            int spaces = nFloors - i - 1;
            int stars = 2 * i + 1;
            tower[i] = repeat(" ", spaces) + repeat("*", stars) + repeat(" ", spaces);
        }
        return tower;
    }

    public static String repeat(String str, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}