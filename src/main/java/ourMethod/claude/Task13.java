package ourMethod.claude;

public class Task13 {
    public static boolean isValidWalk(char[] walk) {
        // Check if walk length is exactly 10 minutes
        if (walk.length != 10) {
            return false;
        }
        
        // Track position relative to start
        int vertical = 0;    // north-south position
        int horizontal = 0;  // east-west position
        
        // Process each direction
        for (char direction : walk) {
            switch (direction) {
                case 'n': vertical++; break;
                case 's': vertical--; break;
                case 'e': horizontal++; break;
                case 'w': horizontal--; break;
            }
        }
        
        // Return true if back at start position
        return vertical == 0 && horizontal == 0;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isValidWalk(new char[]{'n','s','n','s','n','s','n','s','n','s'})); // true
        System.out.println(isValidWalk(new char[]{'w','e','w','e','w','e','w','e','w','e'})); // true
        System.out.println(isValidWalk(new char[]{'n','n','n','s','n','s','n','s','n','s'})); // false
        System.out.println(isValidWalk(new char[]{'n','s','e','w','n','s','e','w','n','s'})); // true
        System.out.println(isValidWalk(new char[]{'n','s','n','s','n','s'})); // false
    }
}
