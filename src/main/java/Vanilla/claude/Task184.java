package Vanilla.claude;

import java.util.*;

class Task184 {
    static class Robot {
        private static Set<String> usedNames = new HashSet<>();
        private static Random random = new Random();
        private String name;
        
        public Robot() {
            reset();
        }
        
        public void reset() {
            name = generateUniqueName();
        }
        
        public String getName() {
            return name;
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
            StringBuilder sb = new StringBuilder();
            // Add 2 random uppercase letters
            for (int i = 0; i < 2; i++) {
                sb.append((char)('A' + random.nextInt(26)));
            }
            // Add 3 random digits
            for (int i = 0; i < 3; i++) {
                sb.append(random.nextInt(10));
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        // Test case 1: Create new robot
        Robot robot1 = new Robot();
        System.out.println("Robot 1 name: " + robot1.getName());

        // Test case 2: Name persists
        System.out.println("Robot 1 name again: " + robot1.getName());

        // Test case 3: New robot gets different name
        Robot robot2 = new Robot();
        System.out.println("Robot 2 name: " + robot2.getName());

        // Test case 4: Reset robot
        robot1.reset();
        System.out.println("Robot 1 after reset: " + robot1.getName());

        // Test case 5: Create multiple robots
        Robot robot3 = new Robot();
        System.out.println("Robot 3 name: " + robot3.getName());
    }
}
