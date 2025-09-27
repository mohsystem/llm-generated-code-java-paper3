package Vanilla.llama31;
public class Task25 {
    public static String[] addLineNumbers(String[] lines) {
        for (int i = 0; i < lines.length; i++) {
            lines[i] = (i + 1) + ": " + lines[i];
        }
        return lines;
    }

    public static void main(String[] args) {
        String[] testCases = {
            new String[]{},
            new String[]{"a", "b", "c"},
            new String[]{"hello", "world"},
            new String[]{"this", "is", "a", "test"},
            new String[]{"single"}
        };

        for (String[] testCase : testCases) {
            String[] result = addLineNumbers(testCase);
            for (String line : result) {
                System.out.println(line);
            }
            System.out.println();
        }
    }
}