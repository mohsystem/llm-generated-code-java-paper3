package CoT.openai;
public class Task19 {
    public static String spinWords(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        
        for (String word : words) {
            if (word.length() >= 5) {
                result.append(new StringBuilder(word).reverse());
            } else {
                result.append(word);
            }
            result.append(" ");
        }
        
        return result.toString().trim();
    }
    
    public static void main(String[] args) {
        System.out.println(spinWords("Hey fellow warriors")); // "Hey wollef sroirraw"
        System.out.println(spinWords("This is a test")); // "This is a test"
        System.out.println(spinWords("This is another test")); // "This is rehtona test"
        System.out.println(spinWords("Coding in Java")); // "gnidoC in Java"
        System.out.println(spinWords("Hello world")); // "olleH dlrow"
    }
}