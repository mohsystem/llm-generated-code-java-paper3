package ourMethod.gemini;
import java.util.ArrayList;
import java.util.List;

public class Task15 {

    public static List<String> towerBuilder(int nFloors) {
        List<String> tower = new ArrayList<>();
        int width = 2 * nFloors - 1;

        for (int i = 1; i <= nFloors; i++) {
            int numStars = 2 * i - 1;
            int numSpaces = (width - numStars) / 2;
            StringBuilder floor = new StringBuilder();
            for (int j = 0; j < numSpaces; j++) {
                floor.append(" ");
            }
            for (int j = 0; j < numStars; j++) {
                floor.append("*");
            }
            for (int j = 0; j < numSpaces; j++) {
                floor.append(" ");
            }
            tower.add(floor.toString());
        }
        return tower;
    }


    public static void main(String[] args) {
        System.out.println(towerBuilder(1));
        System.out.println(towerBuilder(2));
        System.out.println(towerBuilder(3));
        System.out.println(towerBuilder(4));
        System.out.println(towerBuilder(6));

    }
}