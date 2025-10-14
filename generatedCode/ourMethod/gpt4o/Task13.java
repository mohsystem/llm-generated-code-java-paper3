package ourMethod.openai;
public class Task13 {

    public static boolean isValidWalk(String[] walk) {
        if (walk.length != 10) return false;

        int x = 0, y = 0;
        for (String direction : walk) {
            switch (direction) {
                case "n": y++; break;
                case "s": y--; break;
                case "e": x++; break;
                case "w": x--; break;
                default: return false; // Invalid direction
            }
        }
        return x == 0 && y == 0;
    }

    public static void main(String[] args) {
        System.out.println(isValidWalk(new String[]{"n", "s", "n", "s", "n", "s", "n", "s", "n", "s"})); // true
        System.out.println(isValidWalk(new String[]{"n", "n", "n", "s", "s", "s", "e", "w", "e", "w"})); // false
        System.out.println(isValidWalk(new String[]{"n", "s", "n", "s", "n", "s", "n", "s", "e", "w"})); // true
        System.out.println(isValidWalk(new String[]{"e", "w", "e", "w", "e", "w", "e", "w", "e", "w"})); // true
        System.out.println(isValidWalk(new String[]{"n", "e", "n", "e", "n", "e", "n", "e", "n", "e"})); // false
    }
}