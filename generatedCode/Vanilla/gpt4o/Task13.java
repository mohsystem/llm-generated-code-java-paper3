package Vanilla.openai;
public class Task13 {
    public static boolean isValidWalk(char[] walk) {
        if (walk.length != 10) return false;
        int ns = 0, ew = 0;
        for (char direction : walk) {
            switch (direction) {
                case 'n': ns++; break;
                case 's': ns--; break;
                case 'e': ew++; break;
                case 'w': ew--; break;
            }
        }
        return ns == 0 && ew == 0;
    }
    
    public static void main(String[] args) {
        System.out.println(isValidWalk(new char[] {'n','s','n','s','n','s','n','s','n','s'})); // true
        System.out.println(isValidWalk(new char[] {'w','e','w','e','w','e','w','e','w','e'})); // true
        System.out.println(isValidWalk(new char[] {'n','n','n','n','n','n','n','n','n','n'})); // false
        System.out.println(isValidWalk(new char[] {'n','s','e','w','n','s','e','w','n','s'})); // true
        System.out.println(isValidWalk(new char[] {'n','s','e','w','n','s','e','w','n'})); // false
    }
}