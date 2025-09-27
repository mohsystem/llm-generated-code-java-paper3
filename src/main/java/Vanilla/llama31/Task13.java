package Vanilla.llama31;
public class Task13 {
    public static boolean isValidWalk(String[] walk) {
        if (walk.length != 10) return false;
        int x = 0, y = 0;
        for (String dir : walk) {
            switch (dir) {
                case "n":
                    y++;
                    break;
                case "s":
                    y--;
                    break;
                case "e":
                    x++;
                    break;
                case "w":
                    x--;
                    break;
            }
        }
        return x == 0 && y == 0;
    }

    public static void main(String[] args) {
        String[][] testCases = {
            {"n", "s", "n", "s", "n", "s", "n", "s", "n", "s"},
            {"w", "e", "w", "e", "w", "e", "w", "e", "w", "e"},
            {"n", "n", "n", "s", "s", "s", "n", "s", "n", "s"},
            {"e", "w", "e", "w", "e", "w", "e", "w", "e", "w"},
            {"n", "s", "e", "w", "n", "s", "e", "w", "n", "s"}
        };
        for (String[] testCase : testCases) {
            System.out.println(isValidWalk(testCase));
        }
    }
}