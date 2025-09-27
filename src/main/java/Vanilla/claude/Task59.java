package Vanilla.claude;

public class Task59 {
    public static String accum(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            result.append(Character.toUpperCase(str.charAt(i)));
            for (int j = 0; j < i; j++) {
                result.append(Character.toLowerCase(str.charAt(i)));
            }
            if (i < str.length() - 1) {
                result.append("-");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(accum("abcd"));      // A-Bb-Ccc-Dddd
        System.out.println(accum("RqaEzty"));   // R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy
        System.out.println(accum("cwAt"));      // C-Ww-Aaa-Tttt
        System.out.println(accum("ZpglnRxqen")); // Z-Pp-Ggg-Llll-Nnnnn-Rrrrrr-Xxxxxxx-Qqqqqqqq-Eeeeeeeee-Nnnnnnnnnn
        System.out.println(accum("NyffsGeyylB")); // N-Yy-Fff-Ffff-Sssss-Gggggg-Eeeeeee-Yyyyyyyy-Yyyyyyyyy-Llllllllll-Bbbbbbbbbbb
    }
}
