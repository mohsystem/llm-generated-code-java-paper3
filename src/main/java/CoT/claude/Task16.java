package CoT.claude;

public class Task16 {
    public static boolean solution(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }
        return str1.endsWith(str2);
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(solution("abc", "bc")); // true
        System.out.println(solution("abc", "d")); // false
        System.out.println(solution("hello world", "world")); // true
        System.out.println(solution("python", "java")); // false
        System.out.println(solution("programming", "ming")); // true
    }
}
