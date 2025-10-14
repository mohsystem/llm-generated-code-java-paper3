package Vanilla.openai;
public class Task51 {
    public static String encryptString(String input) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : input.toCharArray()) {
            encrypted.append((char) (c + 3));
        }
        return encrypted.toString();
    }

    public static void main(String[] args) {
        System.out.println(encryptString("hello")); // khoor
        System.out.println(encryptString("java")); // mdyd
        System.out.println(encryptString("encryption")); // hqfubswlrq
        System.out.println(encryptString("world")); // zruog
        System.out.println(encryptString("testcase")); // whvwcdrh
    }
}