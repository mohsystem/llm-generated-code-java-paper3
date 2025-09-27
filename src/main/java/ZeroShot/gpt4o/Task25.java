package ZeroShot.gpt4o;
public class Task25 {
    public static void main(String[] args) {
        // Test cases
        String[] result1 = numberLines(new String[]{});
        String[] result2 = numberLines(new String[]{"a", "b", "c"});
        String[] result3 = numberLines(new String[]{"Hello", "World"});
        String[] result4 = numberLines(new String[]{"Java", "Python", "C++"});
        String[] result5 = numberLines(new String[]{"One line"});

        // Print test results
        for (String line : result1) {
            System.out.println(line);
        }
        for (String line : result2) {
            System.out.println(line);
        }
        for (String line : result3) {
            System.out.println(line);
        }
        for (String line : result4) {
            System.out.println(line);
        }
        for (String line : result5) {
            System.out.println(line);
        }
    }

    public static String[] numberLines(String[] lines) {
        String[] numberedLines = new String[lines.length];
        for (int i = 0; i < lines.length; i++) {
            numberedLines[i] = (i + 1) + ": " + lines[i];
        }
        return numberedLines;
    }
}