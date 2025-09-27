package ZeroShot.codestral;
public class Task98 {
    public static void main(String[] args) {
        testConversion("123");
        testConversion("456");
        testConversion("789");
        testConversion("abc");
        testConversion("123.456");
    }

    public static void testConversion(String input) {
        try {
            int result = convertToInt(input);
            System.out.println("Successfully converted '" + input + "' to " + result);
        } catch (NumberFormatException e) {
            System.out.println("Failed to convert '" + input + "' to an integer");
        }
    }

    public static int convertToInt(String input) throws NumberFormatException {
        return Integer.parseInt(input);
    }
}