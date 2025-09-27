package CoT.claude;

public class Task17 {
    public static String toJadenCase(String phrase) {
        if (phrase == null || phrase.isEmpty()) return null;
        
        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = true;
        
        for (char c : phrase.toCharArray()) {
            if (Character.isWhitespace(c)) {
                capitalizeNext = true;
                result.append(c);
            } else {
                if (capitalizeNext) {
                    result.append(Character.toUpperCase(c));
                    capitalizeNext = false;
                } else {
                    result.append(c);
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        // Test cases
        String[] tests = {
            "How can mirrors be real if our eyes aren't real",
            "School is the tool to brainwash the youth",
            "if everybody in the world dropped out of school we would have a much more intelligent society",
            "Most trees are blue",
            "All the rules in this world were made by someone no smarter than you"
        };
        
        for (String test : tests) {
            System.out.println("Original: " + test);
            System.out.println("Jaden Case: " + toJadenCase(test));
            System.out.println();
        }
    }
}
