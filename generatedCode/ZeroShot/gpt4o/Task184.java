package ZeroShot.openai;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Task184 {

    private static final Set<String> usedNames = new HashSet<>();
    private static final Random random = new Random();
    private String name;

    public Task184() {
        reset();
    }

    private static String generateName() {
        StringBuilder nameBuilder;
        do {
            nameBuilder = new StringBuilder();
            nameBuilder.append((char) ('A' + random.nextInt(26)));
            nameBuilder.append((char) ('A' + random.nextInt(26)));
            nameBuilder.append(random.nextInt(10));
            nameBuilder.append(random.nextInt(10));
            nameBuilder.append(random.nextInt(10));
        } while (usedNames.contains(nameBuilder.toString()));
        usedNames.add(nameBuilder.toString());
        return nameBuilder.toString();
    }

    public String getName() {
        return name;
    }

    public void reset() {
        if (name != null) {
            usedNames.remove(name);
        }
        name = generateName();
    }

    public static void main(String[] args) {
        Task184 robot1 = new Task184();
        Task184 robot2 = new Task184();
        Task184 robot3 = new Task184();
        Task184 robot4 = new Task184();
        Task184 robot5 = new Task184();

        System.out.println(robot1.getName());
        System.out.println(robot2.getName());
        System.out.println(robot3.getName());
        System.out.println(robot4.getName());
        System.out.println(robot5.getName());

        robot1.reset();
        System.out.println(robot1.getName());
    }
}