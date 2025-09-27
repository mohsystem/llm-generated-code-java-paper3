package CoT.llama31;
public class Task13 {
    public static boolean isValidWalk(String[] walk) {
        if (walk.length != 10) return false;
        int ns = 0, ew = 0;
        for (String dir : walk) {
            switch (dir) {
                case "n": ns++; break;
                case "s": ns--; break;
                case "e": ew++; break;
                case "w": ew--; break;
            }
        }
        return ns == 0 && ew == 0;
    }

    public static void main(String[] args) {
        String[][] testCases = {
            {"n", "s", "n", "s", "n", "s", "n", "s", "n", "s"},
            {"w", "e", "w", "e", "w", "e", "w", "e", "w", "e"},
            {"n", "n", "n", "s", "n", "s", "n", "s", "n", "s"},
            {"n", "s", "n", "s", "n", "s", "n", "n", "n", "s"},
            {"e", "w", "e", "w", "e", "w", "e", "w", "e", "w"}
        };

        for (String[] testCase : testCases) {
            System.out.println(isValidWalk(testCase));
        }
    }
}