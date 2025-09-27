package CoT.gemini;
import java.util.List;

class Task13 {
    public static boolean isValidWalk(List<Character> walk) {
        if (walk.size() != 10) {
            return false;
        }

        int x = 0;
        int y = 0;

        for (char direction : walk) {
            switch (direction) {
                case 'n':
                    y++;
                    break;
                case 's':
                    y--;
                    break;
                case 'e':
                    x++;
                    break;
                case 'w':
                    x--;
                    break;
            }
        }

        return x == 0 && y == 0;
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

        List<Character> walk5 = List.of('e', 'w', 'e', 'w', 'n', 's', 'n', 's', 'e', 'w');
        System.out.println(isValidWalk(walk5)); // true

    }
}