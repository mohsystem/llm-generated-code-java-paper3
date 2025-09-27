package ourMethod.codestral;
public class Task16 {
    public static boolean solution(String str, String ending) {
        if (str == null || ending == null)
            return false;

        return str.endsWith(ending);
    }

    public static void main(String[] args) {
        System.out.println(solution("abc", "bc")); // returns true
        System.out.println(solution("abc", "d")); // returns false
    }
}