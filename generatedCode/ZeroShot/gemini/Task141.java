package ZeroShot.gemini;
class Task141 {
    public String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public static void main(String[] args) {
        Task141 task = new Task141();
        System.out.println(task.reverseString("hello"));
        System.out.println(task.reverseString("world"));
        System.out.println(task.reverseString("racecar"));
        System.out.println(task.reverseString("apple"));
        System.out.println(task.reverseString(""));
    }
}