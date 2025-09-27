package Vanilla.claude;

public class Task13 {
    public static boolean isValidWalk(char[] walk) {
        if (walk.length != 10) return false;
        
        int x = 0, y = 0;
        for (char direction : walk) {
            switch (direction) {
                case 'n': y++; break;
                case 's': y--; break;
                case 'e': x++; break;
                case 'w': x--; break;
            }
        }
        return x == 0 && y == 0;
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(isValidWalk(new char[] {'n','s','n','s','n','s','n','s','n','s'})); // true
        System.out.println(isValidWalk(new char[] {'w','e','w','e','w','e','w','e','w','e'})); // true
        System.out.println(isValidWalk(new char[] {'w'})); // false
        System.out.println(isValidWalk(new char[] {'n','n','n','s','n','s','n','s','n','s'})); // false
        System.out.println(isValidWalk(new char[] {'n','s','e','w','n','s','e','w','n','s'})); // true
    }
}
