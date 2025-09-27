package Vanilla.codestral;
public class Task59 {
    public static String accum(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i > 0) result.append("-");
            result.append(Character.toUpperCase(c));
            for (int j = 0; j < i; j++) {
                result.append(Character.toLowerCase(c));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(accum("abcd")); // "A-Bb-Ccc-Dddd"
        System.out.println(accum("RqaEzty")); // "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"
        System.out.println(accum("cwAt")); // "C-Ww-Aaa-Tttt"
    }
}