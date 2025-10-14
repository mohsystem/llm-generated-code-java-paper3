package CoT.openai;
public class Task71 {
    public static void main(String[] args) {
        for (String arg : args) {
            try {
                int number = stringToInt(arg);
                System.out.println("Converted integer: " + number);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: " + arg);
            }
        }
    }
    
    public static int stringToInt(String input) {
        return Integer.parseInt(input.trim());
    }
}