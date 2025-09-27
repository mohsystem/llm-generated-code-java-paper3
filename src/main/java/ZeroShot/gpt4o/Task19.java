package ZeroShot.gpt4o;
public class Task19 {
    public static String spinWords(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (word.length() >= 5) {
                result.append(new StringBuilder(word).reverse()).append(" ");
            } else {
                result.append(word).append(" ");
            }
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(spinWords("Hey fellow warriors"));
        System.out.println(spinWords("This is a test"));
        System.out.println(spinWords("This is another test"));
        System.out.println(spinWords("Java programming"));
        System.out.println(spinWords("Secure coding practices"));
    }
}