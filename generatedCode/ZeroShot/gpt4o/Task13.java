package ZeroShot.openai;
import java.util.HashMap;
import java.util.Map;

public class Task13 {
    public static boolean isValidWalk(char[] walk) {
        if (walk.length != 10) return false;
        Map<Character, Integer> counts = new HashMap<>();
        for (char direction : walk) {
            counts.put(direction, counts.getOrDefault(direction, 0) + 1);
        }
        return counts.getOrDefault('n', 0).equals(counts.getOrDefault('s', 0)) &&
               counts.getOrDefault('e', 0).equals(counts.getOrDefault('w', 0));
    }

    public static void main(String[] args) {
        System.out.println(isValidWalk(new char[]{'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 's'})); // true
        System.out.println(isValidWalk(new char[]{'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e'})); // true
        System.out.println(isValidWalk(new char[]{'n', 'n', 'n', 's', 'n', 's', 'n', 's', 'n', 's'})); // false
        System.out.println(isValidWalk(new char[]{'n', 'e', 's', 'w', 'n', 'e', 's', 'w', 'n', 'e'})); // false
        System.out.println(isValidWalk(new char[]{'n', 's', 'e', 'w', 'n', 's', 'e', 'w', 'n', 's'})); // true
    }
}