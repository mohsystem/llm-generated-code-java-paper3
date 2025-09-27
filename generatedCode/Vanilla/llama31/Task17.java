package Vanilla.llama31;
public class Task17 {
    public static String toJadenCase(String phrase) {
        if (phrase == null || phrase.isEmpty()) {
            return null;
        }
        String[] words = phrase.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
        }
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        String[] testCases = {
            "How can mirrors be real if our eyes aren't real",
            "Most trees are blue",
            "If everybody in the world dropped out of school we would have a much more intelligent society",
            "There is no nutrients in our food anymore or in our soil or in our water",
            "You would have to eat 5 apples today to get the same nutritional value as an apple from 1950"
        };
        for (String testCase : testCases) {
            System.out.println(toJadenCase(testCase));
        }
    }
}