package Vanilla.llama31;
public class Task114 {
    public static void main(String[] args) {
        // Test cases
        String s = "GeeksforGeeks";
        System.out.println("Original String: " + s);
        System.out.println("Character at index 4: " + accessCharByIndex(s, 4));
        System.out.println("String after inserting 'for' at index 5: " + insertString(s, "for", 5));
        System.out.println("String after modifying character at index 6: " + modifyChar(s, 6, 'F'));
        System.out.println("String after concatenating ' is great': " + concatenateString(s, " is great"));
    }

    public static char accessCharByIndex(String s, int k) {
        return s.charAt(k);
    }

    public static String insertString(String s, String ch, int k) {
        return s.substring(0, k) + ch + s.substring(k);
    }

    public static String modifyChar(String s, int k, char ch) {
        char[] arr = s.toCharArray();
        arr[k] = ch;
        return new String(arr);
    }

    public static String concatenateString(String s, String ch) {
        return s + ch;
    }
}