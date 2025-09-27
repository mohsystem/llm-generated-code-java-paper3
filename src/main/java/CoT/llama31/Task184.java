package CoT.llama31;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Task184 {
    private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int NAME_LENGTH = 5;
    private static final Random random = new Random();
    private static final Set<String> usedNames = new HashSet<>();

    public static String generateRobotName() {
        while (true) {
            StringBuilder name = new StringBuilder();
            for (int i = 0; i < 2; i++) {
                name.append(LETTERS.charAt(random.nextInt(LETTERS.length())));
            }
            for (int i = 0; i < 3; i++) {
                name.append(random.nextInt(10));
            }
            String generatedName = name.toString();
            if (!usedNames.contains(generatedName)) {
                usedNames.add(generatedName);
                return generatedName;
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("Robot Name: " + generateRobotName());
        }
    }
}