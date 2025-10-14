package ourMethodv2.gpt4o;
public class Task159 {
    public static void main(String[] args) {
        char[] buffer = createBuffer(10);
        
        // Test cases
        System.out.println(readFromBuffer(buffer, 0)); // Should return 'a'
        System.out.println(readFromBuffer(buffer, 1)); // Should return 'b'
        System.out.println(readFromBuffer(buffer, 9)); // Should return 'j'
        System.out.println(readFromBuffer(buffer, -1)); // Should return null
        System.out.println(readFromBuffer(buffer, 10)); // Should return null
    }

    public static char[] createBuffer(int size) {
        char[] buffer = new char[size];
        for (int i = 0; i < size; i++) {
            buffer[i] = (char) ('a' + i);
        }
        return buffer;
    }

    public static Character readFromBuffer(char[] buffer, int index) {
        if (index < 0 || index >= buffer.length) {
            return null; // Improper input validation handled
        }
        return buffer[index];
    }
}