package Vanilla.codestral;
public class Task51 {
    public static String encrypt(String input) {
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            sb.append((char) (c + 1));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(encrypt("Hello"));
        System.out.println(encrypt("World"));
        System.out.println(encrypt("Java"));
        System.out.println(encrypt("Python"));
        System.out.println(encrypt("C++"));
    }
}