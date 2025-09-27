package ourMethod.claude;

public class Task17 {
    public static String toJadenCase(String phrase) {
        // Check for null or empty input
        if (phrase == null || phrase.isEmpty()) {
            return null;
        }
        
        // Split the string into words
        String[] words = phrase.split("\\\\s+");
        StringBuilder result = new StringBuilder();
        
        // Process each word
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 0) {
                // Capitalize first letter and append rest of the word
                result.append(Character.toUpperCase(words[i].charAt(0)))
                      .append(words[i].substring(1));
            }
            // Add space between words, except for last word
            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        // Test cases
        String[] tests = {
            "How can mirrors be real if our eyes aren't real",
            "School Is The Tool To Brainwash The Youth",
            "if everybody in the world dropped out of school we would have a much more intelligent society",
            "All The Rules In This World Were Made By Someone No Smarter Than You",
            null
        };
        
        for (String test : tests) {
            System.out.println("Input: " + test);
            System.out.println("Output: " + toJadenCase(test));
            System.out.println();
        }
    }
}
