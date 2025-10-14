package CoT.openai;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Task184 {
    private static Set<String> existingNames = new HashSet<>();
    private static final Random random = new Random();
    private String name;

    public Task184() {
        reset();
    }

    public String getName() {
        return name;
    }

    public void reset() {
        String newName;
        do {
            newName = generateRandomName();
        } while (existingNames.contains(newName));
        if (name != null) {
            existingNames.remove(name);
        }
        name = newName;
        existingNames.add(name);
    }

    private String generateRandomName() {
        char[] letters = new char[2];
        for (int i = 0; i < 2; i++) {
            letters[i] = (char) ('A' + random.nextInt(26));
        }
        int number = random.nextInt(1000);
        return String.format("%s%03d", new String(letters), number);
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