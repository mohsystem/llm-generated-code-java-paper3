package ourMethod.llama31;
public class Task17 {
    public static String toJadenCase(String phrase) {
        if (phrase == null || phrase.isEmpty()) {
            return null;
        }
        String[] words = phrase.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
        }
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        String[] testCases = {
            "How can mirrors be real if our eyes aren't real",
            "What is the meaning of life?",
            "",
            null
        };
        for (String testCase : testCases) {
            System.out.println("Input: " + testCase);
            System.out.println("Output: " + toJadenCase(testCase));
            System.out.println();
        }
    }
}