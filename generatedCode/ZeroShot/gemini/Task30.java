package ZeroShot.gemini;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Task30 {
    public String longest(String s1, String s2) {
        Set<Character> distinctChars = new HashSet<>();
        for (char c : s1.toCharArray()) {
            distinctChars.add(c);
        }
        for (char c : s2.toCharArray()) {
            distinctChars.add(c);
        }

        char[] resultArray = new char[distinctChars.size()];
        int i = 0;
        for (char c : distinctChars) {
            resultArray[i++] = c;
        }
        Arrays.sort(resultArray);
        return new String(resultArray);

    }

    public static void main(String[] args) {
        Task30 task30 = new Task30();
        System.out.println(task30.longest("xyaabbbccccdefww", "xxxxyyyyabklmopq"));
        System.out.println(task30.longest("abcdefghijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxyz"));
        System.out.println(task30.longest("", ""));
        System.out.println(task30.longest("a", "b"));
        System.out.println(task30.longest("bb", "aa"));


    }
}