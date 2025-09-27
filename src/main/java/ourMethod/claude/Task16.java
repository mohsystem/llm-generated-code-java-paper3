package ourMethod.claude;

public class Task16 {
    public static boolean solution(String str, String ending) {
        // Handle null inputs
        if (str == null || ending == null) {
            return false;
        }
        
        // Handle empty strings
        if (ending.isEmpty()) {
            return true;
        }
        
        // Check if ending is longer than the string
        if (ending.length() > str.length()) {
            return false;
        }
        
        return str.endsWith(ending);
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(solution("abc", "bc"));     // true
        System.out.println(solution("abc", "d"));      // false
        System.out.println(solution("", ""));          // true
        System.out.println(solution("abc", ""));       // true
        System.out.println(solution("abc", "abc"));    // true
    }
}
