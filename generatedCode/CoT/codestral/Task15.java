package CoT.codestral;
import java.util.ArrayList;
import java.util.List;

public class Task15 {
    public static List<String> buildTower(int n) {
        List<String> tower = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tower.add(" ".repeat(n - i - 1) + "*".repeat(2 * i + 1) + " ".repeat(n - i - 1));
        }
        return tower;
    }

    public static void main(String[] args) {
        List<String> tower = buildTower(3);
        for (String s : tower) {
            System.out.println(s);
        }
    }
}