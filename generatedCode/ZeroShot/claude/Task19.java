package ZeroShot.claude;

public class Task19 {
    public static String reverseWords(String str) {
        String[] words = str.split(" ");
        StringBuilder result = new StringBuilder();
        
        for(int i = 0; i < words.length; i++) {
            if(words[i].length() >= 5) {
                result.append(new StringBuilder(words[i]).reverse());
            } else {
                result.append(words[i]);
            }
            if(i < words.length - 1) {
                result.append(" ");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(reverseWords("Hey fellow warriors")); // "Hey wollef sroirraw"
        System.out.println(reverseWords("This is a test")); // "This is a test"
        System.out.println(reverseWords("This is another test")); // "This is rehtona test"
        System.out.println(reverseWords("Welcome")); // "emocleW"
        System.out.println(reverseWords("to the jungle")); // "to the elgnuj"
    }
}
