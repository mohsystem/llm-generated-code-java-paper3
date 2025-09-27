package CoT.gemini;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Task184 {

    private static final Set<String> usedNames = new HashSet<>();
    private static final Random random = new Random();

    public static String generateRobotName() {
        String name;
        do {
            name = generateRandomName();
        } while (usedNames.contains(name));
        usedNames.add(name);
        return name;
    }

    private static String generateRandomName() {
        char letter1 = (char) (random.nextInt(26) + 'A');
        char letter2 = (char) (random.nextInt(26) + 'A');
        int digit1 = random.nextInt(10);
        int digit2 = random.nextInt(10);
        int digit3 = random.nextInt(10);
        return "" + letter1 + letter2 + digit1 + digit2 + digit3;
    }

    public static void resetRobotName(String name) {
        usedNames.remove(name);
    }


    public static void main(String[] args) {
        System.out.println(generateRobotName());
        System.out.println(generateRobotName());
        String name1 = generateRobotName();
        System.out.println(name1);
        resetRobotName(name1);
        System.out.println(generateRobotName());
        System.out.println(generateRobotName());

    }
}