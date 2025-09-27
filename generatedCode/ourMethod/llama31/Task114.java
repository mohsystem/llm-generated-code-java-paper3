package ourMethod.llama31;
public class Task114 {
    public static void main(String[] args) {
        // Test cases
        String str1 = "Hello";
        String str2 = " World!";
        String str3 = "This is a test string";

        // Copying a string
        String copiedStr = copyString(str1);
        System.out.println("Copied String: " + copiedStr);

        // Concatenating strings
        String concatenatedStr = concatenateStrings(str1, str2);
        System.out.println("Concatenated String: " + concatenatedStr);

        // Manipulating string (uppercase)
        String upperCaseStr = toUpperCase(str3);
        System.out.println("Upper Case String: " + upperCaseStr);

        // Manipulating string (substring)
        String subStr = getSubstring(str3, 5, 10);
        System.out.println("Substring: " + subStr);
    }

    public static String copyString(String input) {
        return new String(input);
    }

    public static String concatenateStrings(String str1, String str2) {
        return str1 + str2;
    }

    public static String toUpperCase(String input) {
        return input.toUpperCase();
    }

    public static String getSubstring(String input, int start, int end) {
        if (start < 0 || end > input.length() || start > end) {
            throw new IndexOutOfBoundsException("Invalid indices");
        }
        return input.substring(start, end);
    }
}