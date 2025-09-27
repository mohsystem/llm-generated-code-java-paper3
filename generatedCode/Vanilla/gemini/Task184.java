package Vanilla.gemini;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class Task184 {
    private static final Random random = new Random();
    private static final Set<String> robotNames = new HashSet<>();

    public static String generateRobotName() {
        String name;
        do {
            name = generateName();
        } while (robotNames.contains(name));
        robotNames.add(name);
        return name;
    }

    private static String generateName() {
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
        String robot1 = generateRobotName();
        String robot2 = generateRobotName();
        String robot3 = generateRobotName();
        String robot4 = generateRobotName();
        String robot5 = generateRobotName();

        System.out.println("Robot 1: " + robot1);
        System.out.println("Robot 2: " + robot2);
        System.out.println("Robot 3: " + robot3);
        System.out.println("Robot 4: " + robot4);
        System.out.println("Robot 5: " + robot5);

        resetRobotName(robot3);
        String newRobot3 = generateRobotName();
        System.out.println("New Robot 3: " + newRobot3);


    }
}