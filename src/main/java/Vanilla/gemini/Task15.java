package Vanilla.gemini;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Task15 {
    public List<String> towerBuilder(int nFloors) {
        List<String> tower = new ArrayList<>();
        for (int i = 1; i <= nFloors; i++) {
            int stars = 2 * i - 1;
            int spaces = nFloors - i;
            String floor = String.join("", java.util.Collections.nCopies(spaces, " ")) +
                            String.join("", java.util.Collections.nCopies(stars, "*")) +
                            String.join("", java.util.Collections.nCopies(spaces, " "));
            tower.add(floor);
        }
        return tower;
    }

    public static void main(String[] args) {
        Task15 task15 = new Task15();
        System.out.println(task15.towerBuilder(1));
        System.out.println(task15.towerBuilder(3));
        System.out.println(task15.towerBuilder(6));
        System.out.println(task15.towerBuilder(0));
        System.out.println(task15.towerBuilder(10));


    }
}