package Vanilla.openai;
public class Task17 {
    public static String toJadenCase(String phrase) {
        if (phrase == null || phrase.isEmpty()) {
            return null;
        }
        String[] words = phrase.split(" ");
        StringBuilder jadenCased = new StringBuilder();
        for (String word : words) {
            jadenCased.append(Character.toUpperCase(word.charAt(0)))
                      .append(word.substring(1))
                      .append(" ");
        }
        return jadenCased.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(toJadenCase("How can mirrors be real if our eyes aren't real"));
        System.out.println(toJadenCase("the moment that truth is organized it becomes a lie"));
        System.out.println(toJadenCase("school is the tool to brainwash the youth"));
        System.out.println(toJadenCase("if newborn babies could speak they would be the most intelligent beings on planet earth"));
        System.out.println(toJadenCase(""));
    }
}