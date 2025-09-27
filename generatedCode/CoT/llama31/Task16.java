package CoT.llama31;
public class Task16 {
    public static boolean solution(String str, String ending) {
        if (str == null || ending == null) {
            throw new NullPointerException("Input strings cannot be null");
        }
        int lenStr = str.length();
        int lenEnding = ending.length();
        if (lenEnding > lenStr) {
            return false;
        }
        return str.substring(lenStr - lenEnding).equals(ending);
    }

    public static void main(String[] args) {
        System.out.println(solution("abc", "bc")); // true
        System.out.println(solution("abc", "d")); // false
        System.out.println(solution("abcde", "de")); // true
        System.out.println(solution("abcde", "e")); // true
        System.out.println(solution("abcde", "abc")); // false
    }
}