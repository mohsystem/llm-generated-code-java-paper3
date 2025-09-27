package Vanilla.gemini;
class Task16 {
    public boolean solution(String str, String ending) {
        if (str == null || ending == null || str.length() < ending.length()) {
            return false;
        }
        return str.endsWith(ending);
    }

    public static void main(String[] args) {
        Task16 task16 = new Task16();
        System.out.println(task16.solution("abc", "bc")); // true
        System.out.println(task16.solution("abc", "d")); // false
        System.out.println(task16.solution("hello", "lo")); // true
        System.out.println(task16.solution("coding", "ing")); //true
        System.out.println(task16.solution("samurai", "ra")); // false
    }
}