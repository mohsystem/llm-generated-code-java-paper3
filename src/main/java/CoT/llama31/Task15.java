package CoT.llama31;
public class Task15 {
    public static String[] towerBuilder(int nFloors) {
        String[] tower = new String[nFloors];
        for (int i = 0; i < nFloors; i++) {
            int spaces = nFloors - i - 1;
            int stars = 2 * i + 1;
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
        for (int i = 1; i <= 5; i++) {
            String[] tower = towerBuilder(i);
            System.out.println("Tower with " + i + " floors:");
            for (String floor : tower) {
                System.out.println(floor);
            }
            System.out.println();
        }
    }
}