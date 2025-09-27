package ourMethod.gpt4o;
public class Task59 {
    public static String accum(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            result.append(Character.toUpperCase(ch));
            for (int j = 0; j < i; j++) {
                result.append(Character.toLowerCase(ch));
            }
            if (i != s.length() - 1) {
                result.append('-');
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(accum("abcd"));     // Output: "A-Bb-Ccc-Dddd"
        System.out.println(accum("RqaEzty"));  // Output: "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"
        System.out.println(accum("cwAt"));     // Output: "C-Ww-Aaa-Tttt"
        System.out.println(accum("xYz"));      // Output: "X-Yy-Zzz"
        System.out.println(accum("mM"));       // Output: "M-Mm"
    }
}