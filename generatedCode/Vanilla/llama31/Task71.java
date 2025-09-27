package Vanilla.llama31;
// Compile and run using javac and java commands
public class Task71 {
    public static void main(String[] args) {
        for (String arg : args) {
            try {
                int num = Integer.parseInt(arg);
                System.out.println("Converted integer: " + num);
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer: " + arg);
            }
        }
    }
}