package CoT.openai;
public class Task15 {
    public static String[] buildTower(int floors) {
        String[] tower = new String[floors];
        for (int i = 0; i < floors; i++) {
            int spaces = floors - i - 1;
            int stars = i * 2 + 1;
            tower[i] = " ".repeat(spaces) + "*".repeat(stars) + " ".repeat(spaces);
        }
        return tower;
    }

    public static void main(String[] args) {
        String[][] testCases = {
            buildTower(3),
            buildTower(6),
            buildTower(1),
            buildTower(4),
            buildTower(0)
        };

        for (String[] testCase : testCases) {
            for (String line : testCase) {
                System.out.println(line);
            }
            System.out.println();
        }
    }
}