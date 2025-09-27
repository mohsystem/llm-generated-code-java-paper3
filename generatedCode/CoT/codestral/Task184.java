package CoT.codestral;
import java.util.*;

public class Task184 {
    private static Set<String> usedNames = new HashSet<>();
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final Random random = new SecureRandom();

    public static String generateName() {
        String name;
        do {
            name = generateRandomName();
        } while (usedNames.contains(name));
        usedNames.add(name);
        return name;
    }

    public static void resetName(String oldName) {
        usedNames.remove(oldName);
    }

    private static String generateRandomName() {
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            name.append(UPPERCASE_LETTERS.charAt(random.nextInt(UPPERCASE_LETTERS.length())));
        }
        for (int i = 0; i < 3; i++) {
            name.append(random.nextInt(10));
        }
        return name.toString();
    }

    public static void main(String[] args) {
        System.out.println(generateName()); // Test case 1
        System.out.println(generateName()); // Test case 2
        String name = generateName(); // Test case 3
        System.out.println(name);
        resetName(name);
        System.out.println(generateName()); // Test case 4 (should be different from previous name)
        System.out.println(generateName()); // Test case 5
    }
}