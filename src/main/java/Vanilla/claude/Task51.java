package Vanilla.claude;

public class Task51 {
    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        
        for(int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if(Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                ch = (char)(base + ((ch - base + shift) % 26));
            }
            result.append(ch);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(encrypt("Hello World!", 3));  // "Khoor Zruog!"
        System.out.println(encrypt("OpenAI", 5));        // "TujsFN"
        System.out.println(encrypt("ABCXYZ", 1));        // "BCDYZA" 
        System.out.println(encrypt("Testing123", 7));    // "Alzapun123"
        System.out.println(encrypt("Crypto", 25));       // "Bqxosn"
    }
}
