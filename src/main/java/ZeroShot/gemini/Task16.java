package ZeroShot.gemini;
class Task16 {
    public boolean solution(String str, String ending) {
        if (str == null || ending == null) {
            return false;
        }
        int strLen = str.length();
        int endingLen = ending.length();
        if (endingLen > strLen) {
            return false;
        }
        return str.substring(strLen - endingLen).equals(ending);
    }

    public static void main(String[] args) {
        Task16 task16 = new Task16();
        System.out.println(task16.solution("abc", "bc")); // true
        System.out.println(task16.solution("abc", "d"));  // false
        System.out.println(task16.solution("abcde", "cde")); // true
        System.out.println(task16.solution("abc", "abc")); // true
        System.out.println(task16.solution("abc", "")); // true


    }
}