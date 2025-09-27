package CoT.gpt4o;
public class Task51 {
    public static String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder();
        int key = 3; // Simple Caesar cipher shift key
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                c = (char) ((c - base + key) % 26 + base);
            }
            encrypted.append(c);
        }
        return encrypted.toString();
    }

    public static void main(String[] args) {
        System.out.println(encrypt("Hello World"));  // Test case 1
        System.out.println(encrypt("Java Programming"));  // Test case 2
        System.out.println(encrypt("Secure Code"));  // Test case 3
        System.out.println(encrypt("Encrypt this text!"));  // Test case 4
        System.out.println(encrypt("Task51 Example"));  // Test case 5
    }
}