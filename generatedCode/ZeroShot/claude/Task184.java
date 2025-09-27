package ZeroShot.claude;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class Task184 {
    private static Set<String> usedNames = new HashSet<>();
    private static Random random = new Random();
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
        name = generateUniqueName();
    }
    
    private String generateUniqueName() {
        String newName;
        do {
            newName = generateName();
        } while (usedNames.contains(newName));
        usedNames.add(newName);
        return newName;
    }
    
    private String generateName() {
        StringBuilder name = new StringBuilder();
        // Generate 2 uppercase letters
        for (int i = 0; i < 2; i++) {
            name.append((char) (random.nextInt(26) + 'A'));
        }
        // Generate 3 digits
        for (int i = 0; i < 3; i++) {
            name.append(random.nextInt(10));
        }
        return name.toString();
    }

    public static void main(String[] args) {
        // Test cases
        for (int i = 0; i < 5; i++) {
            Task184 robot = new Task184();
            System.out.println("Robot " + (i+1) + " name: " + robot.getName());
            if (i % 2 == 0) {
                System.out.println("Resetting Robot " + (i+1));
                robot.reset();
                System.out.println("Robot " + (i+1) + " new name: " + robot.getName());
            }
        }
    }
}
