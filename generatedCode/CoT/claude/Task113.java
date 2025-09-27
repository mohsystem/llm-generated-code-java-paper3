package CoT.claude;

public class Task113 {
    public static String concatenateStrings(String... strings) {
        if (strings == null) {
            return "";
        }
        
        StringBuilder result = new StringBuilder();
        for (String str : strings) {
            if (str != null) {
                result.append(str);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        // Test case 1: Basic concatenation
        System.out.println(concatenateStrings("Hello", " ", "World"));
        
        // Test case 2: Empty strings
        System.out.println(concatenateStrings("", "Test", ""));
        
        // Test case 3: Null values
        System.out.println(concatenateStrings("First", null, "Third"));
        
        // Test case 4: Single string
        System.out.println(concatenateStrings("OnlyString"));
        
        // Test case 5: All null values
        System.out.println(concatenateStrings(null));
    }
}
