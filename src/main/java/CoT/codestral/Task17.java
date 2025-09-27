package CoT.codestral;
public class Task17 {
    public static String toJadenCase(String phrase) {
        if (phrase == null || phrase.equals(""))
            return null;

        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;

        for (char c : phrase.toCharArray()) {
            if (isFirst && !Character.isWhitespace(c))
                sb.append(Character.toUpperCase(c));
            else {
                if (Character.isWhitespace(c))
                    isFirst = true;
                else
                    sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(toJadenCase("How can mirrors be real if our eyes aren't real"));
        System.out.println(toJadenCase("I rather be a warrior in a garden than a garden warrior"));
        System.out.println(toJadenCase(""));
        System.out.println(toJadenCase(null));
        System.out.println(toJadenCase("I'm the greatest artist of all time!"));
    }
}