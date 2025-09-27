package ourMethod.gemini;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Task13 {
    public static boolean isValidWalk(List<Character> walk) {
        if (walk.size() != 10) {
            return false;
        }

        Map<Character, Integer> counts = new HashMap<>();
        counts.put('n', 0);
        counts.put('s', 0);
        counts.put('e', 0);
        counts.put('w', 0);

        for (char direction : walk) {
            counts.put(direction, counts.get(direction) + 1);
        }

        return counts.get('n') == counts.get('s') && counts.get('e') == counts.get('w');
    }

    public static void main(String[] args) {
        List<Character> walk1 = List.of('n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 's');
        System.out.println(isValidWalk(walk1)); // true

        List<Character> walk2 = List.of('w', 'e', 'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e');
        System.out.println(isValidWalk(walk2)); // false

        List<Character> walk3 = List.of('w');
        System.out.println(isValidWalk(walk3)); // false

        List<Character> walk4 = List.of('n', 'n', 'n', 's', 'n', 's', 'n', 's', 'n', 's');
        System.out.println(isValidWalk(walk4)); // false

        List<Character> walk5 = List.of('e', 'w', 'n', 's', 'n', 's', 'e', 'w', 'n', 's');
        System.out.println(isValidWalk(walk5)); // true


    }
}