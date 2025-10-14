package Vanilla.gemini;

import java.util.Arrays;

public class Task15 {

    /**
     * Builds a pyramid-shaped tower as an array of strings.
     *
     * @param nFloors The number of floors in the tower (must be positive).
     * @return An array of strings representing the tower.
     */
    public static String[] buildTower(int nFloors) {
        if (nFloors <= 0) {
            return new String[0];
        }

        String[] tower = new String[nFloors];
        int towerWidth = 2 * nFloors - 1;

        for (int i = 0; i < nFloors; i++) {
            int floorNumber = i + 1;
            int stars = 2 * floorNumber - 1;
            int spaces = (towerWidth - stars) / 2;

            StringBuilder sb = new StringBuilder();
            // Using String.repeat() (Java 11+) for conciseness
            sb.append(" ".repeat(spaces));
            sb.append("*".repeat(stars));
            sb.append(" ".repeat(spaces));

            tower[i] = sb.toString();
        }
        return tower;
    }

    public static void main(String[] args) {
        int[] testCases = {1, 3, 6, 0, 10};

        for (int i = 0; i < testCases.length; i++) {
            int n = testCases[i];
            System.out.println("Test Case " + (i + 1) + ": nFloors = " + n);
            String[] tower = buildTower(n);

            if (tower.length == 0) {
                System.out.println("[]");
            } else {
                System.out.println("[");
                for (String floor : tower) {
                    System.out.println("  \"" + floor + "\"");
                }
                System.out.println("]");
            }
            System.out.println();
        }
    }
}