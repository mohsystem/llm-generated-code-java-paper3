package ourMethod.codestral;
public class Task51 {
    public static String encrypt(String text, int s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                char ch = (char)(((int)text.charAt(i) + s - 65) % 26 + 65);
                result.append(ch);
            } else {
                char ch = (char)(((int)text.charAt(i) + s - 97) % 26 + 97);
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(encrypt("HELLO", 4)); // prints "LIPPS"
    }
}