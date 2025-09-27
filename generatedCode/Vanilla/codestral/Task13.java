package Vanilla.codestral;
public class Task13 {
    public static boolean isValidWalk(char[] walk) {
        if (walk.length != 10) return false;
        int x = 0, y = 0;
        for (char dir : walk) {
            switch (dir) {
                case 'n': y++; break;
                case 's': y--; break;
                case 'e': x++; break;
                case 'w': x--; break;
            }
        }
        return x == 0 && y == 0;
    }

    public static void main(String[] args) {
        System.out.println(isValidWalk(new char[]{'n','s','n','s','n','s','n','s','n','s'})); // true
        System.out.println(isValidWalk(new char[]{'w','e','w','e','w','e','w','e','w','e','w','e'})); // false
        System.out.println(isValidWalk(new char[]{'w'})); // false
        System.out.println(isValidWalk(new char[]{'n','n','n','n','n','n','n','n','n','n'})); // false
        System.out.println(isValidWalk(new char[]{'n','s','e','w','n','s','e','w','n','s'})); // true
    }
}