package Vanilla.gemini;
public class Task45 {

    public static int processInput(int num) {
        try {
            if (num < 0) {
                throw new IllegalArgumentException("Input must be non-negative.");
            }
            return num * 2;
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
            return -1; // Or another appropriate error value
        }
    }


    public static void main(String[] args) {
        System.out.println(processInput(5));
        System.out.println(processInput(-2));
        System.out.println(processInput(0));
        System.out.println(processInput(10));
        System.out.println(processInput(-5));
    }
}