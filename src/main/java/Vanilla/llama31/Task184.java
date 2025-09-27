package Vanilla.llama31;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Task184 {
    private static Map<String, Boolean> usedNames = new HashMap<>();
    private static Random random = new Random();

    public static String generateRobotName() {
        while (true) {
            String name = generateRandomName();
            if (!usedNames.containsKey(name)) {
                usedNames.put(name, true);
                return name;
            }
        }
    }

    private static String generateRandomName() {
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            name.append((char) ('A' + random.nextInt(26)));
        }
        for (int i = 0; i < 3; i++) {
            name.append(random.nextInt(10));
        }
        return name.toString();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("Robot Name: " + generateRobotName());
        }
    }
}