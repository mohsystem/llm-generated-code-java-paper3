package CoT.claude;

import java.security.SecureRandom;
import java.util.*;

public class Task184 {
    static class Robot {
        private static final Set<String> usedNames = new HashSet<>();
        private static final Random random = new SecureRandom();
        private String name;

        public Robot() {
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
                // Generate two random uppercase letters
                for (int i = 0; i < 2; i++) {
                    sb.append((char) (random.nextInt(26) + 'A'));
                }
                // Generate three random digits
                for (int i = 0; i < 3; i++) {
                    sb.append(random.nextInt(10));
                }
                newName = sb.toString();
            } while (usedNames.contains(newName));
            
            usedNames.add(newName);
            return newName;
        }
    }

    public static void main(String[] args) {
        // Test cases
        for (int i = 0; i < 5; i++) {
            Robot robot = new Robot();
            System.out.println("Robot " + (i+1) + " initial name: " + robot.getName());
            robot.reset();
            System.out.println("Robot " + (i+1) + " after reset: " + robot.getName());
        }
    }
}
