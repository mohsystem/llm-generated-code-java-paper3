package Vanilla.llama31;
public class Task25 {
    public static String[] addLineNumbers(String[] lines) {
        for (int i = 0; i < lines.length; i++) {
            lines[i] = (i + 1) + ": " + lines[i];
        }
        return lines;
    }
}