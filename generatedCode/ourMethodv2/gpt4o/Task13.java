package ourMethodv2.gpt4o;
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
                default: return false; // In case of invalid direction
            }
        }
        return x == 0 && y == 0;
    }

    public static void main(String[] args) {
        System.out.println(isValidWalk(new char[] {'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 's'})); // true
        System.out.println(isValidWalk(new char[] {'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e'})); // true
        System.out.println(isValidWalk(new char[] {'n', 'n', 'n', 'n', 'n', 's', 's', 's', 's', 's'})); // false
        System.out.println(isValidWalk(new char[] {'n', 'e', 'n', 'e', 'n', 'e', 'n', 'e', 'n', 'e'})); // false
        System.out.println(isValidWalk(new char[] {'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n'})); // false
    }
}