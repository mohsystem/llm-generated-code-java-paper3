package Vanilla.claude;

public class Task19 {
    public static String reverseWords(String str) {
        String[] words = str.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() >= 5) {
                words[i] = new StringBuilder(words[i]).reverse().toString();
            }
        }
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        String[] tests = {
            "Hey fellow warriors",
            "This is a test",
            "This is another test",
            "Welcome",
            "Just a simple sentence"
        };
        
        for (String test : tests) {
            System.out.println("Input: " + test);
            System.out.println("Output: " + reverseWords(test));
            System.out.println();
        }
    }
}
