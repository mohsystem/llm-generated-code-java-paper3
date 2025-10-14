package ourMethod.openai;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Task184 {
    private static final Set<String> usedNames = new HashSet<>();
    private String name;

    public Task184() {
        reset();
    }

    public String getName() {
        if (name == null) {
            reset();
        }
        return name;
    }

    public void reset() {
        String newName;
        do {
            newName = generateRandomName();
        } while (usedNames.contains(newName));
        if (name != null) {
            usedNames.remove(name);
        }
        name = newName;
        usedNames.add(name);
    }

    private String generateRandomName() {
        Random rand = new Random();
        char[] nameArray = new char[5];
        nameArray[0] = (char) ('A' + rand.nextInt(26));
        nameArray[1] = (char) ('A' + rand.nextInt(26));
        nameArray[2] = (char) ('0' + rand.nextInt(10));
        nameArray[3] = (char) ('0' + rand.nextInt(10));
        nameArray[4] = (char) ('0' + rand.nextInt(10));
        return new String(nameArray);
    }

    public static void main(String[] args) {
        Task184 robot1 = new Task184();
        System.out.println(robot1.getName());
        robot1.reset();
        System.out.println(robot1.getName());

        Task184 robot2 = new Task184();
        System.out.println(robot2.getName());

        Task184 robot3 = new Task184();
        System.out.println(robot3.getName());

        Task184 robot4 = new Task184();
        System.out.println(robot4.getName());

        Task184 robot5 = new Task184();
        System.out.println(robot5.getName());
    }
}