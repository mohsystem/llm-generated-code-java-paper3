package CoT.llama31;
public class Task25 {
    public static String[] addLineNumbers(String[] lines) {
        String[] numberedLines = new String[lines.length];
        for (int i = 0; i < lines.length; i++) {
            numberedLines[i] = (i + 1) + ": " + lines[i];
        }
        return numberedLines;
    }

    public static void main(String[] args) {
        String[] testCases = {
            "",
            "a",
            "b",
            "c"
        };
        String[] testCases2 = {
            "a", "b", "c"
        };
        String[] testCases3 = {};
        String[] result1 = addLineNumbers(testCases);
        String[] result2 = addLineNumbers(testCases2);
        String[] result3 = addLineNumbers(testCases3);

        for (String line : result1) {
            System.out.println(line);
        }
        System.out.println("----------------------------");
        for (String line : result2) {
            System.out.println(line);
        }
        System.out.println("----------------------------");
        for (String line : result3) {
            System.out.println(line);
        }
    }
}