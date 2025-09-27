package ZeroShot.llama31;
public class Task25 {
    public static String[] addLineNumbers(String[] lines) {
        for (int i = 0; i < lines.length; i++) {
            lines[i] = (i + 1) + ": " + lines[i];
        }
        return lines;
    }

//    public static void main(String[] args) {
//        String[] testCases = new String[][]{
//            new String[]{},
//            new String[]{"a", "b", "c"},
//            new String[]{"hello", "world"},
//            new String[]{"line1", "line2", "line3", "line4"},
//            new String[]{"single line"}
//        };
//
//        for (String[] testCase : testCases) {
//            String[] result = addLineNumbers(testCase);
//            for (String line : result) {
//                System.out.println(line);
//            }
//            System.out.println();
//        }
//    }
}