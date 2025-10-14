package ourMethod.openai;
public class Task17 {

    public static String toJadenCase(String phrase) {
        if (phrase == null || phrase.isEmpty()) {
            return null;
        }

        String[] words = phrase.split("\\s+");
        StringBuilder jadenCase = new StringBuilder();

        for (String word : words) {
            if (word.length() > 0) {
                jadenCase.append(Character.toUpperCase(word.charAt(0)));
                jadenCase.append(word.substring(1).toLowerCase());
                jadenCase.append(" ");
            }
        }

        return jadenCase.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(toJadenCase("How can mirrors be real if our eyes aren't real")); // "How Can Mirrors Be Real If Our Eyes Aren't Real"
        System.out.println(toJadenCase("")); // null
        System.out.println(toJadenCase(null)); // null
        System.out.println(toJadenCase("jaden smith's twitter is so interesting")); // "Jaden Smith's Twitter Is So Interesting"
        System.out.println(toJadenCase("life is a mystery to be lived")); // "Life Is A Mystery To Be Lived"
    }
}