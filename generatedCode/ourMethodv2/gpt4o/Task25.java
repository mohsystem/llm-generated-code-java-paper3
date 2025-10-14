package ourMethodv2.gpt4o;
public class Task25 {
    public static List<String> lineNumbering(List<String> lines) {
        List<String> numberedLines = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            numberedLines.add((i + 1) + ": " + lines.get(i));
        }
        return numberedLines;
    }

    public static void main(String[] args) {
        System.out.println(lineNumbering(Arrays.asList()));
        System.out.println(lineNumbering(Arrays.asList("a", "b", "c")));
        System.out.println(lineNumbering(Arrays.asList("Hello", "World")));
        System.out.println(lineNumbering(Arrays.asList("Java", "is", "fun")));
        System.out.println(lineNumbering(Arrays.asList("Line 1", "Line 2", "Line 3", "Line 4")));
    }
}