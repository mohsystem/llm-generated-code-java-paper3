package ZeroShot.gpt4o;
public class Task51 {
    public static String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : input.toCharArray()) {
            encrypted.append((char) (c + 3)); // Simple Caesar Cipher shifting by 3
        }
        return encrypted.toString();
    }

    public static void main(String[] args) {
        System.out.println(encrypt("hello"));  // khoor
        System.out.println(encrypt("world"));  // zruog
        System.out.println(encrypt("java"));   // mdyd
        System.out.println(encrypt("test"));   // whvw
        System.out.println(encrypt("secure")); // vhfxuh
    }
}