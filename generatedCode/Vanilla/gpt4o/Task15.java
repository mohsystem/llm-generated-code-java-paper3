package Vanilla.gpt4o;
public class Task15 {
    public static String[] buildTower(int floors) {
        String[] tower = new String[floors];
        for (int i = 0; i < floors; i++) {
            int spaces = floors - i - 1;
            int stars = 2 * i + 1;
            tower[i] = " ".repeat(spaces) + "*".repeat(stars) + " ".repeat(spaces);
        }
        return tower;
    }

    public static void main(String[] args) {
        int[] testCases = {1, 2, 3, 4, 5};
        for (int floors : testCases) {
            String[] result = buildTower(floors);
            for (String row : result) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}