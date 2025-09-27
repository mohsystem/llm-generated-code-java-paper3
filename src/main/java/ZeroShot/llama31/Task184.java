package ZeroShot.llama31;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;

public class Task184 {
    private static Set<String> usedNames = new HashSet<>();
    private static Random random = new Random();

    public static String generateRobotName() {
        while (true) {
            String name = generateRandomName();
            if (!usedNames.contains(name)) {
                usedNames.add(name);
                return name;
            }
        }
    }

    public static String generateRandomName() {
        StringBuilder name = new StringBuilder();
        name.append((char) ('A' + random.nextInt(26)));
        name.append((char) ('A' + random.nextInt(26)));
        name.append(String.format("%03d", random.nextInt(1000)));
        return name.toString();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("Robot Name: " + generateRobotName());
        }
    }
}