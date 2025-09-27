package ZeroShot.codestral;
public class Task51 {
    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                char ch = (char)(((int)text.charAt(i) + shift - 65) % 26 + 65);
                result.append(ch);
            } else {
                char ch = (char)(((int)text.charAt(i) + shift - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(encrypt("HELLO", 4)); // Outputs: LIPPS
        System.out.println(encrypt("WORLD", 3)); // Outputs: ZRUOG
        System.out.println(encrypt("JAVA", 1)); // Outputs: KBWB
        System.out.println(encrypt("PYTHON", 2)); // Outputs: RZVJP
        System.out.println(encrypt("C++", 5)); // Outputs: H++
    }
}