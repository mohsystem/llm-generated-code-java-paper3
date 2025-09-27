package ourMethod.llama31;
public class Task25 {
    public static void main(String[] args) {
        String[] input = {"a", "b", "c"};
        String[] output = addLineNumbers(input);
        for (String line : output) {
            System.out.println(line);
        }
    }

    public static String[] addLineNumbers(String[] lines) {
        String[] numberedLines = new String[lines.length];
        for (int i = 0; i < lines.length; i++) {
            numberedLines[i] = (i + 1) + ": " + lines[i];
        }
        return numberedLines;
    }
}