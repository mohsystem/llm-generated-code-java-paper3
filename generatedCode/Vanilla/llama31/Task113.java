package Vanilla.llama31;
public class Task113 {
    public static void main(String[] args) {
        String[] testCases = {
            "Hello", "World",
            "This", "is", "a", "test",
            "Concatenating", "multiple", "strings",
            "Java", "is", "fun",
            "Programming", "is", "awesome"
        };

        for (int i = 0; i < testCases.length; i += 2) {
            String result = concatenate(testCases, i, Math.min(i + 2, testCases.length));
            System.out.println(result);
        }
    }

    public static String concatenate(String[] strings, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++) {
            sb.append(strings[i]);
            if (i < end - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}