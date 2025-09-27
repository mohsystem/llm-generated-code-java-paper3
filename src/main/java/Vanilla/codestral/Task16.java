package Vanilla.codestral;
public class Task16 {
    public static boolean solution(String str, String ending) {
        return str.endsWith(ending);
    }

    public static void main(String[] args) {
        System.out.println(solution("abc", "bc")); // returns true
        System.out.println(solution("abc", "d")); // returns false
        System.out.println(solution("abcd", "cd")); // returns true
        System.out.println(solution("abcd", "bc")); // returns false
        System.out.println(solution("abcd", "d")); // returns true
    }
}