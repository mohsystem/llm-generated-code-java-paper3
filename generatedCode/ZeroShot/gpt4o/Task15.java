package ZeroShot.gpt4o;
public class Task15 {
    public static String[] buildTower(int floors) {
        String[] tower = new String[floors];
        int width = 2 * floors - 1;

        for (int i = 0; i < floors; i++) {
            int stars = 2 * i + 1;
            int spaces = (width - stars) / 2;
            StringBuilder floor = new StringBuilder();

            for (int j = 0; j < spaces; j++) {
                floor.append(" ");
            }
            for (int j = 0; j < stars; j++) {
                floor.append("*");
            }
            for (int j = 0; j < spaces; j++) {
                floor.append(" ");
            }
            tower[i] = floor.toString();
        }
        return tower;
    }

    public static void main(String[] args) {
        int[] testCases = {1, 2, 3, 5, 6};
        for (int floors : testCases) {
            String[] result = buildTower(floors);
            for (String line : result) {
                System.out.println(line);
            }
            System.out.println();
        }
    }
}