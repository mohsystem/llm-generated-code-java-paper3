package CoT.gemini;
class Task141 {
    public static String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseString("hello"));
        System.out.println(reverseString("world"));
        System.out.println(reverseString(""));
        System.out.println(reverseString("12345"));
        System.out.println(reverseString("racecar"));
    }
}