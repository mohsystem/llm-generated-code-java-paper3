package Vanilla.claude;

class Task104 {
    public static String handleInput(String input, int bufferSize) {
        if (input == null || bufferSize <= 0) {
            return "";
        }
        return input.length() > bufferSize ? input.substring(0, bufferSize) : input;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(handleInput("Hello World", 5));  // "Hello"
        System.out.println(handleInput("Test", 10));        // "Test" 
        System.out.println(handleInput("Programming", 4));  // "Prog"
        System.out.println(handleInput("", 5));            // ""
        System.out.println(handleInput("Java", 0));        // ""
    }
}
