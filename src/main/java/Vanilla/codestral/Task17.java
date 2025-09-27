package Vanilla.codestral;
public class Task17 {
    public static String toJadenCase(String phrase) {
        if (phrase == null || phrase.equals(""))
            return null;

        String[] words = phrase.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = Character.toUpperCase(words[i].charAt(0)) + words[i].substring(1);
        }
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        System.out.println(toJadenCase("How can mirrors be real if our eyes aren't real")); // "How Can Mirrors Be Real If Our Eyes Aren't Real"
        System.out.println(toJadenCase("")); // null
        System.out.println(toJadenCase(null)); // null
    }
}