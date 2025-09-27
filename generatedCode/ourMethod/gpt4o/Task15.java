package ourMethod.gpt4o;
public class Task15 {
    public static String[] buildTower(int floors) {
        String[] tower = new String[floors];
        for (int i = 0; i < floors; i++) {
            int numSpaces = floors - i - 1;
            int numStars = 2 * i + 1;
            tower[i] = " ".repeat(numSpaces) + "*".repeat(numStars) + " ".repeat(numSpaces);
        }
        return tower;
    }

    public static void main(String[] args) {
        int[] testCases = {1, 2, 3, 4, 5};
        for (int floors : testCases) {
            System.out.println("Tower with " + floors + " floors:");
            for (String row : buildTower(floors)) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}