package ZeroShot.openai;
public class Task71 {
    public static Integer convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return null; // Return null if conversion fails
        }
    }

    public static void main(String[] args) {
        String[] testInputs = {"123", "456", "789", "abc", "1000"};
        for (String input : testInputs) {
            Integer result = convertStringToInt(input);
            if (result != null) {
                System.out.println("Conversion succeeded: " + result);
            } else {
                System.out.println("Conversion failed for input: " + input);
            }
        }
    }
}