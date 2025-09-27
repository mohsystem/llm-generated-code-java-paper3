package ourMethod.llama31;
public class Task16 {
    public static boolean solution(String str1, String str2) {
        // Check if str1 is null or str2 is null to avoid NullPointerException
        if (str1 == null || str2 == null) {
            return false;
        }
        // Check if str2 is longer than str1 to avoid IndexOutOfBoundsException
        if (str2.length() > str1.length()) {
            return false;
        }
        // Use substring to check if str1 ends with str2
        return str1.endsWith(str2);
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(solution("abc", "bc"));   // true
        System.out.println(solution("abc", "d"));    // false
        System.out.println(solution("abc", "abc"));  // true
        System.out.println(solution("abc", "abcd")); // false
        System.out.println(solution(null, "bc"));     // false
    }
}