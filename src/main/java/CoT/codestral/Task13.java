package CoT.codestral;
public class Task13 {
    public static void main(String[] args) {
        System.out.println(isValidWalk(new char[]{'n','s','n','s','n','s','n','s','n','s'}));
        System.out.println(isValidWalk(new char[]{'w','e','w','e','w','e','w','e','w','e','w','e'}));
        System.out.println(isValidWalk(new char[]{'w'}));
        System.out.println(isValidWalk(new char[]{'n','n','n','s','n','s','n','s','n','s'}));
    }

    public static boolean isValidWalk(char[] walk) {
        if (walk.length != 10) return false;
        int x = 0;
        int y = 0;
        for (char c : walk) {
            if (c == 'n') y++;
            else if (c == 's') y--;
            else if (c == 'e') x++;
            else if (c == 'w') x--;
        }
        return x == 0 && y == 0;
    }
}