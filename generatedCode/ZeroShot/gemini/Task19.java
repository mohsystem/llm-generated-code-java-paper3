package ZeroShot.gemini;
import java.util.*;

class Task19 {
    public String spinWords(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (word.length() >= 5) {
                sb.append(new StringBuilder(word).reverse().toString()).append(" ");
            } else {
                sb.append(word).append(" ");
            }
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        Task19 task19 = new Task19();
        System.out.println(task19.spinWords("Hey fellow warriors"));
        System.out.println(task19.spinWords("This is a test"));
        System.out.println(task19.spinWords("This is another test"));
        System.out.println(task19.spinWords("Hello"));
        System.out.println(task19.spinWords("Welcome to the world"));

    }
}