package ourMethodv2.gpt4o;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Task184 {
    private String name;
    private static final Set<String> usedNames = new HashSet<>();
    private static final Random random = new Random();

    public Task184() {
        reset();
    }

    public String getName() {
        return name;
    }

    public void reset() {
        String newName;
        do {
            newName = generateRandomName();
        } while (usedNames.contains(newName));
        if (name != null) {
            usedNames.remove(name);
        }
        name = newName;
        usedNames.add(newName);
    }

    private String generateRandomName() {
        char[] letters = new char[2];
        letters[0] = (char) ('A' + random.nextInt(26));
        letters[1] = (char) ('A' + random.nextInt(26));
        int digits = random.nextInt(1000);
        return String.format("%s%s%03d", letters[0], letters[1], digits);
    }

    public static void main(String[] args) {
        Task184[] robots = new Task184[5];
        for (int i = 0; i < 5; i++) {
            robots[i] = new Task184();
            System.out.println("Robot " + i + " name: " + robots[i].getName());
            robots[i].reset();
            System.out.println("Robot " + i + " reset name: " + robots[i].getName());
        }
    }
}