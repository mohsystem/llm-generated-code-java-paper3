package ourMethod.codestral;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

  class Robot {
    private String name;
    private static Set<String> existingNames = new HashSet<>();
    private static Random random = new Random();

    public String getName() {
        if (name == null) {
            name = generateName();
        }
        return name;
    }

    public void resetName() {
        name = null;
    }

    private String generateName() {
        String newName;
        do {
            newName = generateRandomName();
        } while (existingNames.contains(newName));
        existingNames.add(newName);
        return newName;
    }

    private String generateRandomName() {
        StringBuilder sb = new StringBuilder();
        sb.append((char) (random.nextInt(26) + 'A'));
        sb.append((char) (random.nextInt(26) + 'A'));
        sb.append(String.format("%03d", random.nextInt(1000)));
        return sb.toString();
    }

    public static void main(String[] args) {
        Robot robot1 = new Robot();
        Robot robot2 = new Robot();
        System.out.println(robot1.getName());
        System.out.println(robot2.getName());
        robot1.resetName();
        System.out.println(robot1.getName());
        System.out.println(robot2.getName());
    }
}