package Vanilla.openai;
public class Task59 {
    public static String accum(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = Character.toUpperCase(s.charAt(i));
            result.append(ch);
            for (int j = 0; j < i; j++) {
                result.append(Character.toLowerCase(ch));
            }
            if (i < s.length() - 1) {
                result.append('-');
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(accum("abcd"));      // "A-Bb-Ccc-Dddd"
        System.out.println(accum("RqaEzty"));   // "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"
        System.out.println(accum("cwAt"));      // "C-Ww-Aaa-Tttt"
        System.out.println(accum("hello"));     // "H-Ee-Lll-Llll-Ooooo"
        System.out.println(accum("java"));      // "J-Aa-Vvv-Aaaa"
    }
}