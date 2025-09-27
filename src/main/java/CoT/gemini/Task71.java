package CoT.gemini;
public class Task71 {

    public static int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1; // Or throw an exception, depending on desired behavior
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide input as command line arguments.");
            return;
        }

        for (String arg : args) {
            int result = convertToInt(arg);
            if (result != -1) {
                System.out.println("Converted value: " + result);
            } else {
                System.out.println("Invalid input: " + arg);
            }
        }



        // Test cases
        System.out.println(convertToInt("123")); // Output: 123
        System.out.println(convertToInt("-456")); // Output: -456
        System.out.println(convertToInt("0")); // Output: 0
        System.out.println(convertToInt("123a")); // Output: -1 (or exception)
        System.out.println(convertToInt("1.23")); // Output: -1 (or exception)



    }
}