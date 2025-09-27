package ourMethod.gpt4o;
public class Task114 {
    public String copyString(String input) {
        if (input == null) return null;
        return new String(input);
    }

    public String concatenateStrings(String str1, String str2) {
        if (str1 == null) str1 = "";
        if (str2 == null) str2 = "";
        return str1.concat(str2);
    }

    public String reverseString(String input) {
        if (input == null) return null;
        return new StringBuilder(input).reverse().toString();
    }

    public static void main(String[] args) {
        Task114 task = new Task114();
        
        System.out.println("Copy: " + task.copyString("hello")); // hello
        System.out.println("Concat: " + task.concatenateStrings("hello", " world")); // hello world
        System.out.println("Reverse: " + task.reverseString("hello")); // olleh
        System.out.println("Copy Null: " + task.copyString(null)); // null
        System.out.println("Concat Nulls: " + task.concatenateStrings(null, null)); // (empty string)
    }
}