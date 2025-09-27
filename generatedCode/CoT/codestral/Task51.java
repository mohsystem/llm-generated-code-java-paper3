package CoT.codestral;
public class Task51 {
    public static String encrypt(String input) {
        // This is a simple Caesar cipher implementation for encryption.
        // It shifts each character by 3 places to the right in the alphabet.
        StringBuilder encrypted = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                if (Character.isLowerCase(c)) {
                    encrypted.append((char) ((c - 'a' + 3) % 26 + 'a'));
                } else if (Character.isUpperCase(c)) {
                    encrypted.append((char) ((c - 'A' + 3) % 26 + 'A'));
                }
            } else {
                encrypted.append(c);
            }
        }
        return encrypted.toString();
    }

    public static void main(String[] args) {
        System.out.println(encrypt("Hello, World!")); // "Khoor, Zruog!"
        System.out.println(encrypt("Java Programming")); // "Mdwd Surtjplqj"
        System.out.println(encrypt("Secure Coding")); // "Vhfxuh Fqlgwbr"
        System.out.println(encrypt("Cybersecurity")); // "Fbyhubhvfuhwuh"
        System.out.println(encrypt("Information Technology")); // "Lqjyhuwhuwlwkrwhvwdq"
    }
}