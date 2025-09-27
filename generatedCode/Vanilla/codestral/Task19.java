package Vanilla.codestral;
public class Task19 {
    public static String reverseFiveOrMore(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (word.length() >= 5) {
                sb.append(new StringBuilder(word).reverse().toString());
            } else {
                sb.append(word);
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseFiveOrMore("Hey fellow warriors")); // "Hey wollef sroirraw"
        System.out.println(reverseFiveOrMore("This is a test")); // "This is a test"
        System.out.println(reverseFiveOrMore("This is another test")); // "This is rehtona test"
    }
}