package CoT.claude;

public class Task51 {
    public static String encrypt(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }
        
        StringBuilder encrypted = new StringBuilder();
        final int SHIFT = 3; // Caesar cipher shift value
        
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                ch = (char) (((ch - base + SHIFT) % 26) + base);
            }
            encrypted.append(ch);
        }
        
        return encrypted.toString();
    }

    public static void main(String[] args) {
        // Test cases
        String[] tests = {
            "Hello World!",
            "OpenAI",
            "Testing123",
            "ENCRYPT this",
            "Special@#$Characters"
        };
        
        for (String test : tests) {
            System.out.println("Original: " + test);
            System.out.println("Encrypted: " + encrypt(test));
            System.out.println();
        }
    }
}
