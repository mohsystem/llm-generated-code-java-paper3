package ZeroShot.llama31;
public class Task17 {
    public static String toJadenCase(String phrase) {
        if (phrase == null || phrase.isEmpty()) {
            return null;
        }
        String[] words = phrase.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
        }
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        System.out.println(toJadenCase("How can mirrors be real if our eyes aren't real"));
        System.out.println(toJadenCase("Not Jaden-Cased: 'How can mirrors be real if our eyes aren't real'"));
        System.out.println(toJadenCase(""));
        System.out.println(toJadenCase(null));
        System.out.println(toJadenCase("this is a test"));
    }
}