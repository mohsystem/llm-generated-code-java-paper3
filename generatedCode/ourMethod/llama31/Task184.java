package ourMethod.llama31;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;

public class Task184 {
    private static Set<String> existingNames = new HashSet<>();
    private static Random random = new Random();

    public static String generateRobotName() {
        while (true) {
            String name = generateRandomName();
            if (!existingNames.contains(name)) {
                existingNames.add(name);
                return name;
            }
        }
    }

    public static String generateRandomName() {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "0123456789";
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            name.append(letters.charAt(random.nextInt(letters.length())));
        }
        for (int i = 0; i < 3; i++) {
            name.append(digits.charAt(random.nextInt(digits.length())));
        }
        return name.toString();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("Robot Name: " + generateRobotName());
        }
    }
}