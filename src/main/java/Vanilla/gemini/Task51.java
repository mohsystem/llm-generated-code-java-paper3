package Vanilla.gemini;
class Task51 {
    public String encrypt(String text) {
        String encryptedText = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            encryptedText += (char) (c + 1);
        }
        return encryptedText;
    }

    public static void main(String[] args) {
        Task51 task51 = new Task51();
        System.out.println(task51.encrypt("hello"));
        System.out.println(task51.encrypt("world"));
        System.out.println(task51.encrypt("test"));
        System.out.println(task51.encrypt("123"));
        System.out.println(task51.encrypt(""));
    }
}