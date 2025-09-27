package Vanilla.gemini;
class Task79 {
    public static String encrypt(String message, String secretKey) {
        StringBuilder encryptedMessage = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            int keyIndex = i % secretKey.length();
            char keyChar = secretKey.charAt(keyIndex);
            encryptedMessage.append((char) (c ^ keyChar));
        }
        return encryptedMessage.toString();
    }

    public static void main(String[] args) {
        System.out.println(encrypt("hello", "key"));
        System.out.println(encrypt("world", "secret"));
        System.out.println(encrypt("test", "password"));
        System.out.println(encrypt("message", "cipher"));
        System.out.println(encrypt("java", "programming"));

    }
}