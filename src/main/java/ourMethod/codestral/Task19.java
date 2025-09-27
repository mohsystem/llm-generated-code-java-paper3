package ourMethod.codestral;
public class Task19 {
    public static String spinWords(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (word.length() >= 5) {
                StringBuilder reversed = new StringBuilder(word);
                result.append(reversed.reverse().toString());
            } else {
                result.append(word);
            }
            result.append(" ");
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(spinWords("Hey fellow warriors"));
        System.out.println(spinWords("This is a test"));
        System.out.println(spinWords("This is another test"));
    }
}