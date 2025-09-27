package ZeroShot.gpt4o;
public class Task17 {
    public static void main(String[] args) {
        System.out.println(toJadenCase("How can mirrors be real if our eyes aren't real"));
        System.out.println(toJadenCase("the quick brown fox jumps over the lazy dog"));
        System.out.println(toJadenCase("hello world"));
        System.out.println(toJadenCase(""));
        System.out.println(toJadenCase(null));
    }

    public static String toJadenCase(String phrase) {
        if (phrase == null || phrase.isEmpty()) return null;
        String[] words = phrase.split(" ");
        StringBuilder jadenCased = new StringBuilder();
        for (String word : words) {
            if (word.length() > 0) {
                jadenCased.append(Character.toUpperCase(word.charAt(0)))
                          .append(word.substring(1))
                          .append(" ");
            }
        }
        return jadenCased.toString().trim();
    }
}