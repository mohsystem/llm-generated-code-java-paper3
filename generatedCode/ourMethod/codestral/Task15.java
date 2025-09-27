package ourMethod.codestral;
import java.util.ArrayList;
import java.util.List;

public class Task15 {
    public static List<String> buildTower(int nFloors) {
        if (nFloors <= 0) {
            throw new IllegalArgumentException("Number of floors must be a positive integer");
        }

        List<String> tower = new ArrayList<>();
        for (int i = 0; i < nFloors; i++) {
            String spaces = " ".repeat(nFloors - i - 1);
            String stars = "*".repeat(2 * i + 1);
            tower.add(spaces + stars + spaces);
        }
        return tower;
    }

    public static void main(String[] args) {
        List<String> tower3 = buildTower(3);
        List<String> tower6 = buildTower(6);
        System.out.println(tower3);
        System.out.println(tower6);
    }
}