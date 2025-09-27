package Vanilla.gemini;
class Task141 {
    public String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static void main(String[] args) {
        Task141 task = new Task141();
        System.out.println(task.reverseString("hello")); // olleh
        System.out.println(task.reverseString("world")); // dlrow
        System.out.println(task.reverseString("racecar")); // racecar
        System.out.println(task.reverseString("madam")); // madam
        System.out.println(task.reverseString("")); // 
    }
}