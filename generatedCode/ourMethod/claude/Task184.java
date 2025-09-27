package ourMethod.claude;

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
            StringBuilder sb = new StringBuilder();
            // Generate 2 random uppercase letters
            for (int i = 0; i < 2; i++) {
                sb.append((char) (random.nextInt(26) + 'A'));
            }
            // Generate 3 random digits
            for (int i = 0; i < 3; i++) {
                sb.append(random.nextInt(10));
            }
            newName = sb.toString();
        } while (usedNames.contains(newName));
        
        usedNames.add(newName);
        return newName;
    }
    
    public static void main(String[] args) {
        // Test cases
        Task184 robot1 = new Task184();
        System.out.println("Robot 1: " + robot1.getName());
        System.out.println("Same name: " + robot1.getName());
        
        Task184 robot2 = new Task184();
        System.out.println("Robot 2: " + robot2.getName());
        
        robot1.reset();
        System.out.println("Robot 1 after reset: " + robot1.getName());
        
        Task184 robot3 = new Task184();
        System.out.println("Robot 3: " + robot3.getName());
        
        Task184 robot4 = new Task184();
        System.out.println("Robot 4: " + robot4.getName());
    }
}
