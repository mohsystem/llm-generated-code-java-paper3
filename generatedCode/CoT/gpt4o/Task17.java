package CoT.gpt4o;
public class Task17 {
    public static String toJadenCase(String phrase) {
        if (phrase == null || phrase.isEmpty()) {
            return null;
        }
        String[] words = phrase.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)))
                      .append(word.substring(1))
                      .append(" ");
            }
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(toJadenCase("How can mirrors be real if our eyes aren't real")); // How Can Mirrors Be Real If Our Eyes Aren't Real
        System.out.println(toJadenCase("most trees are blue")); // Most Trees Are Blue
        System.out.println(toJadenCase("")); // null
        System.out.println(toJadenCase(null)); // null
        System.out.println(toJadenCase("the quick brown fox jumps over the lazy dog")); // The Quick Brown Fox Jumps Over The Lazy Dog
    }
}