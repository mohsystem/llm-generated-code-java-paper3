package CoT.gemini;
public class Task17 {

    public String toJadenCase(String phrase) {
        if (phrase == null || phrase.isEmpty()) {
            return null;
        }

        StringBuilder jadenCase = new StringBuilder();
        String[] words = phrase.split(" ");

        for (String word : words) {
            jadenCase.append(Character.toUpperCase(word.charAt(0)));
            if (word.length() > 1) {
                jadenCase.append(word.substring(1));
            }
            jadenCase.append(" ");
        }

        return jadenCase.toString().trim();
    }


    public static void main(String[] args) {
        Task17 task17 = new Task17();

        String[] testCases = {
                "How can mirrors be real if our eyes aren't real",
                "most trees are blue",
                "",
                null,
                "the moment that truth is organized it becomes a lie"
        };
        String[] expected = {
                "How Can Mirrors Be Real If Our Eyes Aren't Real",
                "Most Trees Are Blue",
                null,
                null,
                "The Moment That Truth Is Organized It Becomes A Lie"
        };

        for (int i = 0; i < testCases.length; i++) {
            String result = task17.toJadenCase(testCases[i]);
            System.out.println("Test case " + (i + 1) + ": " + (result == null ? "null" : "\"" + result + "\"") +
                    (result == null ? (expected[i] == null ? " (PASS)" : " (FAIL)") :
                            (result.equals(expected[i]) ? " (PASS)" : " (FAIL)")));
        }

    }
}