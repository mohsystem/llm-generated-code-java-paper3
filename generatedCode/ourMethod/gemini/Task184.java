package ourMethod.gemini;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class Task184 {
    private static final Set<String> robotNames = new HashSet<>();
    private static final Random random = new Random();

    public static String generateRobotName() {
        String name;
        do {
            name = generateRandomName();
        } while (robotNames.contains(name));
        robotNames.add(name);
        return name;
    }

    private static String generateRandomName() {
        char[] letters = new char[2];
        for (int i = 0; i < 2; i++) {
            letters[i] = (char) (random.nextInt(26) + 'A');
        }
        int digits = random.nextInt(1000);
        return new String(letters) + String.format("%03d", digits);
    }


    public static void resetRobotName(String name) {
        robotNames.remove(name);
    }

    public static void main(String[] args) {
        System.out.println(generateRobotName());
        System.out.println(generateRobotName());
        String name = generateRobotName();
        System.out.println(name);
        resetRobotName(name);
        System.out.println(generateRobotName());
        System.out.println(generateRobotName());


    }
}