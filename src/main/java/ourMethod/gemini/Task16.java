package ourMethod.gemini;
class Task16 {
    public static boolean solution(String str, String ending) {
        if (str == null || ending == null || ending.length() > str.length()) {
            return false;
        }
        return str.endsWith(ending);
    }

    public static void main(String[] args) {
        System.out.println(solution("abc", "bc")); // true
        System.out.println(solution("abc", "d"));  // false
        System.out.println(solution("abc", ""));   // true
        System.out.println(solution("", "bc"));   // false
        System.out.println(solution(null, "bc")); // false

    }
}