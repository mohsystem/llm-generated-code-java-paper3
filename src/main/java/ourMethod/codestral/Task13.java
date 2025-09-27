package ourMethod.codestral;
public class Task13 {
    public static boolean isValidWalk(char[] walk) {
        if (walk.length != 10)
            return false;
        int x = 0, y = 0;
        for (char direction : walk) {
            if (direction == 'n') y++;
            else if (direction == 's') y--;
            else if (direction == 'e') x++;
            else if (direction == 'w') x--;
        }
        return x == 0 && y == 0;
    }

    public static void main(String[] args) {
        System.out.println(isValidWalk(new char[] {'n','s','n','s','n','s','n','s','n','s'})); // true
        System.out.println(isValidWalk(new char[] {'w','e','w','e','w','e','w','e','w','e','w','e'})); // false
        System.out.println(isValidWalk(new char[] {'w'})); // false
        System.out.println(isValidWalk(new char[] {'n','n','n','s','n','s','n','s','n','s'})); // false
    }
}