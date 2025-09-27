package ourMethod.codestral;
public class Task17 {
    public static String toJadenCase(String phrase) {
        if (phrase == null || phrase.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String[] words = phrase.split(" ");
        for (String word : words) {
            sb.append(Character.toUpperCase(word.charAt(0)));
            sb.append(word.substring(1));
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(toJadenCase("How can mirrors be real if our eyes aren't real"));
        System.out.println(toJadenCase("I'm gonna lose control like i've done before"));
        System.out.println(toJadenCase(""));
        System.out.println(toJadenCase(null));
    }
}