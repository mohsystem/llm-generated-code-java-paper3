package ourMethodv2.gpt4o;
public class Task17 {
    public static String toJadenCase(String phrase) {
        if (phrase == null || phrase.isEmpty()) {
            return null;
        }
        String[] words = phrase.split("\\s+");
        StringBuilder jadenCased = new StringBuilder();
        for (String word : words) {
            if (word.length() > 0) {
                jadenCased.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
            }
        }
        return jadenCased.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(toJadenCase("How can mirrors be real if our eyes aren't real"));
        System.out.println(toJadenCase("the karate kid was a great movie"));
        System.out.println(toJadenCase("after earth wasn't well received"));
        System.out.println(toJadenCase("i am not a human"));
        System.out.println(toJadenCase(null));
    }
}