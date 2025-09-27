package Vanilla.llama31;
public class Task16 {
    public static boolean solution(String str, String suffix) {
        return str.endsWith(suffix);
    }

    public static void main(String[] args) {
        System.out.println(solution("abc", "bc")); // true
        System.out.println(solution("abc", "d")); // false
        System.out.println(solution("hello world", "world")); // true
        System.out.println(solution("hello world", "hello")); // false
        System.out.println(solution("test", "test")); // true
    }
}