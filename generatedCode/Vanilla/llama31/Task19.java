package Vanilla.llama31;
public class Task19 {
    public static void main(String[] args) {
        System.out.println(reverseWords("Hey fellow warriors"));
        System.out.println(reverseWords("This is a test"));
        System.out.println(reverseWords("This is another test"));
        System.out.println(reverseWords("Hello World"));
        System.out.println(reverseWords("Python is fun"));
    }

    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() >= 5) {
                words[i] = new StringBuilder(words[i]).reverse().toString();
            }
        }
        return String.join(" ", words);
    }
}