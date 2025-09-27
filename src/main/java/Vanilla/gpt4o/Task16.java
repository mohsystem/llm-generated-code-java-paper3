package Vanilla.gpt4o;
public class Task16 {

    public static boolean solution(String str, String ending) {
        return str.endsWith(ending);
    }

    public static void main(String[] args) {
        System.out.println(solution("abc", "bc")); // true
        System.out.println(solution("abc", "d"));  // false
        System.out.println(solution("hello", "lo"));  // true
        System.out.println(solution("java", "a"));  // true
        System.out.println(solution("python", "py"));  // false
    }
}