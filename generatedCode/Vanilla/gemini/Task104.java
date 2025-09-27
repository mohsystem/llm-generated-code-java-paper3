package Vanilla.gemini;
class Task104 {
    public static String handleInput(String input, int bufferSize) {
        if (input.length() > bufferSize) {
            return input.substring(0, bufferSize);
        } else {
            return input;
        }
    }

    public static void main(String[] args) {
        System.out.println(handleInput("Hello", 10));
        System.out.println(handleInput("This is a long string", 10));
        System.out.println(handleInput("", 5));
        System.out.println(handleInput("Short", 20));
        System.out.println(handleInput("Exactly ten chars", 10));
    }
}