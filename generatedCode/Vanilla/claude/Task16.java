package Vanilla.claude;

public class Task16 {
    public static boolean solution(String str, String ending) {
        return str.endsWith(ending);
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(solution("abc", "bc")); // true
        System.out.println(solution("abc", "d")); // false
        System.out.println(solution("samurai", "ai")); // true
        System.out.println(solution("ninja", "ja")); // true
        System.out.println(solution("sensei", "i")); // true
    }
}
