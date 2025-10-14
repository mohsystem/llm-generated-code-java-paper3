package ourMethodv2.gpt4o;
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
        for (int testCase : testCases) {
            String[] result = buildTower(testCase);
            for (String line : result) {
                System.out.println(line);
            }
            System.out.println();
        }
    }
}