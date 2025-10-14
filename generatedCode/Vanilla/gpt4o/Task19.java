package Vanilla.openai;
public class Task19 {
    public static String spinWords(String sentence) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() >= 5) {
                words[i] = new StringBuilder(words[i]).reverse().toString();
            }
        }
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        System.out.println(spinWords("Hey fellow warriors")); // "Hey wollef sroirraw"
        System.out.println(spinWords("This is a test")); // "This is a test"
        System.out.println(spinWords("This is another test")); // "This is rehtona test"
        System.out.println(spinWords("Java programming")); // "Java gnimmargorp"
        System.out.println(spinWords("Kata is fun")); // "Kata is fun"
    }
}