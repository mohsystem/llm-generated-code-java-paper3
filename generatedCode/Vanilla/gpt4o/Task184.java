package Vanilla.gpt4o;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Task184 {
    private static final Set<String> usedNames = new HashSet<>();
    private String name;
    private Random random = new Random();

    public Task184() {
        reset();
    }

    public String getName() {
        return name;
    }

    public void reset() {
        do {
            name = generateRandomName();
        } while (usedNames.contains(name));
        usedNames.add(name);
    }

    private String generateRandomName() {
        char[] letters = new char[2];
        for (int i = 0; i < 2; i++) {
            letters[i] = (char) ('A' + random.nextInt(26));
        }
        int number = random.nextInt(1000);
        return String.format("%s%03d", new String(letters), number);
    }

    public static void main(String[] args) {
        Task184 robot1 = new Task184();
        System.out.println("Robot1: " + robot1.getName());
        robot1.reset();
        System.out.println("Robot1 after reset: " + robot1.getName());

        Task184 robot2 = new Task184();
        System.out.println("Robot2: " + robot2.getName());

        Task184 robot3 = new Task184();
        System.out.println("Robot3: " + robot3.getName());

        Task184 robot4 = new Task184();
        System.out.println("Robot4: " + robot4.getName());

        Task184 robot5 = new Task184();
        System.out.println("Robot5: " + robot5.getName());
    }
}